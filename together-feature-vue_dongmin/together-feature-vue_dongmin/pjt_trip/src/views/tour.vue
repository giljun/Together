<template>
  <div>
    <Header></Header>
    <!-- scale, slide, slide-x, slide-y -->
    <div class="text-xs-center">
     <v-menu offset-y
        origin="center center"
        transition="scale-transition"
        bottom>
        <v-btn slot="activator" color="primary" dark>
        {{locate}}
        </v-btn>
         <v-list>
         <v-list-tile
           v-for="(item, index) in tour.props.areas"
           :key="index"
           @click="locate_click(index)">
           <v-list-tile-title>{{ item }}</v-list-tile-title>
         </v-list-tile>
         </v-list>
     </v-menu>

     <v-menu offset-y
        transition="slide-x-transition"
        bottom
        right>
        <v-btn slot="activator" color="primary" dark class="deep-orange">
          {{type}}
        </v-btn>
         <v-list>
           <v-list-tile
             v-for="(item, index) in tour.props.types"
             :key="index"
             @click="type_click(index)">
             <v-list-tile-title>{{ item[0]}}</v-list-tile-title>
           </v-list-tile>
         </v-list>
     </v-menu>
      <v-menu v-if="type !== '테마 추천'"
        transition="slide-y-transition"
        bottom>
        <v-btn slot="activator" color="primary" dark class="purple">
          {{thema1}}
        </v-btn>
        <v-list>
          <v-list-tile v-for="( index, item ) in tour.props.types[thema_index][1]" :key="index" @click="thema1_click(item)">
            <v-list-tile-title>{{ item }}</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-menu>
     <v-btn icon><v-icon @click="informLocate(locate,type,thema1)">search</v-icon></v-btn>

    </div>
    <template class="font_notable" v-if="tour.props.trip_inform.length">
      <paginated-list :list-array="tour.props.trip_inform" />
    </template>

  </div>
</template>
<script>
import Header from '@/components/Header'
import tour from '@/views/tour'
import { posix } from 'path'
import PaginatedList from './PaginatedList'

export default {
  name: 'tour',
  components : {
    Header,
    PaginatedList,
  },
  props: {
    areas: {
      1: '서울', 2: '인천', 3: '대전', 4: '대구', 5: '광주', 6: '부산', 7: '울산', 8: '세종특별자치시',
      31: '경기도', 32: '강원도', 33: '충청북도', 34: '충청남도', 35: '경상북도', 36: '경상남도', 37: '전라북도', 38: '전라남도', 39: '제주도'
    },
    types: {
      12 : ['관광지',{'자연관광지':'A0101','관광자원': 'A0102','역사관광지': 'A0201','휴양관광지': 'A0202','체험관광지': 'A0203','산업관광지': 'A0204','건축/조형물': 'A0205'}] ,
      14: ['문화시설',{'문화시설':'A0206'}],
      15: ['행사/공연/축제',{'축제': 'A0207','공연/행사': 'A0208'}],
      25: ['여행코스',{'가족코스' : 'C0112', '나홀로코스': 'C0113', '힐링코스': 'C0114', '도보코스': 'C0115', '캠핑코스': 'C0116','맛코스': 'C0117'}],
      28: ['레포츠',{'레포츠소개': 'A0301', '육상레포츠': 'A0302', '수상레포츠': 'A0303', '항공레포츠': 'A0304','복합레포츠': 'A0305'}],
      32: ['숙박',{'숙박시설': 'B0201'}],
      38: ['쇼핑',{'쇼핑': 'A0401'}],
      39: ['음식점',{'음식점': 'A0502'}]
    },
    click_areas: '지역 선택',
    click_type: '테마 추천',
    trip_inform: {type:Object},
    click_thema1: '분류 선택'
  },
  data () {
    return {
      tour,
      locate: tour.props.click_areas.type,
      type: tour.props.click_type.type,
      thema1: tour.props.click_thema1.type,
      thema_index:''
    }
  },
  methods: {
    informLocate(area,type,thema1){
      console.log(area,type)
      var url='http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey='
      var key='rbssLvuPaumnRlgRCPsgU5IeLlHAf5nHHGU8P3JVSYqJvgSFL8l%2FJbCYNE9zVd5Je%2BFoFlSBFo%2Fochd7h97a%2Fg%3D%3D'
      var URL= url+key+'&MobileOS=ETC&MobileApp=AppTest&areaCode='
      //지역 선택할 경우
      if (area !== '지역 선택'){
        for(let [key, value] of Object.entries(tour.props.areas)){
          //선택한 지역 분류data에서 번호 불러오기
          if(area === value){
            var spring_url = 'http://192.168.31.84:8080/api/AreaCode/'+key
            axios.get(spring_url).then((res)=>{
              console.log(1)
              console.log(res)
              //테마 선택안하고 지역만 선택할 경우
              if(type === '테마 추천'){
                tour.props.trip_inform=res.data
                console.log(tour.props.trip_inform)
                PaginatedList.props.pageNum.type=0
              } else if(type !== '테마 추천'){ //지역선택후 테마 선택
                for(let [key1, value] of Object.entries(tour.props.types)){
                  //테마 분류된 테이블중에서 선택한 테마의 번호를 가져오기 위함
                  if(type === value[0]){
                    console.log(type)
                    var list_restype=[] //리스트에 저장해서 뿌려줄 data에 저장
                    for ( var [index,res_type] of Object.entries(res.data) ){
                      //선택한 테마 번호와 data 테마id와 같은 것 불러오기
                      if (res_type.content_type_id === Number(key1)){
                        if(thema1 === '분류 선택')
                          {list_restype.push(res_type)} //리스트 저장
                        else if(thema1 !== '분류 선택'){
                          console.log(tour.props.types[key1][1][thema1])
                          if(tour.props.types[key1][1][thema1] === res_type.cat2){
                            list_restype.push(res_type)
                          }
                        }
                      }
                    }//리스트저장for문
                    console.log(list_restype)
                    tour.props.trip_inform=list_restype //뿌려줄 vue data에 저장한다.
                    PaginatedList.props.pageNum.type=0
                }//if(type === value)
              }//types for문
            }//테마선택한 else if
          })//axios
            .catch(err => {
              console.log(err);
            })//.catch
          }//if(area === value)
        }//area for문
      } else if(area === '지역 선택'){ //지역 선택안할 경우, 선택하라고 알람
        alert('지역 검색어를 선택해주세요!')
      }
      // axios.get(URL)
    },
    locate_click(index){
      console.log(index)
      console.log(tour.props.areas[index])
      this.locate=tour.props.areas[index]
    },
    type_click(index){
      console.log(index)
      console.log(tour.props.types[index][0])
      this.type=tour.props.types[index][0]
      this.thema_index=index
    },
    thema1_click(item){
      console.log(item)
      this.thema1=item
    },
  },
    created () {
      $(window).on('load', function () {
        load('#js-load', '4');
        console.log(1)
        $("#js-btn-wrap .button").on("click", function () {
        load('#js-load', '4', '#js-btn-wrap');
        console.log(2)
        })
      });
    },
}
</script>
<style>
.font_pacifico {
  font-family: 'Pacifico', cursive;
}
.font_indei {
  font-family: 'Pacifico', cursive;
  font-family: 'Darker Grotesque', sans-serif;
  font-family: 'Hanalei', cursive;
  font-family: 'Indie Flower', cursive;
  font-weight: bold;
}
.font_notable{
  font-family: 'Pacifico', cursive;
  font-family: 'Darker Grotesque', sans-serif;
  font-family: 'Hanalei', cursive;
  font-family: 'Indie Flower', cursive;
  font-family: 'Anton', sans-serif;
  font-family: 'Notable', sans-serif;
  font-weight: bold;
}
.font_Gaegu{
  font-family: 'Gaegu', cursive;
}
.font_Noto{
  font-family: 'Noto Serif KR', serif;
  font-weight: 600;
}
.font_Yeon{
  font-family: 'Noto Serif KR', serif;
  font-family: 'Nanum Gothic Coding', monospace;
  font-family: 'Yeon Sung', cursive;
}
</style>
