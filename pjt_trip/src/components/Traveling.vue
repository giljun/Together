<template>
    <div v-if="this.$session.get('lo')" class="travel">
      <h1 class="my-5 text-xs-center">
        {{this.$session.get('lo').nickname}}님은 현재 대전에서 여행중이시네요! </h1>
      <v-container>
        <v-layout wrap align-center>
        <v-flex><Map></Map></v-flex>
        <v-flex wrap align-center>
          <p>대전 지역의 테마 별 여행지 추천을 도와드릴까요?
          <v-btn color="pink" dark v-show="click_thema==false" @click="click_thema=true">테마추천</v-btn>
          <v-menu v-if="click_thema" offset-y
             transition="slide-x-transition"
             bottom
             right>
             <v-btn slot="activator" color="#FF9800" dark class="deep-orange">
               {{type}}
             </v-btn>
              <v-list>
                <v-list-tile
                  v-for="(item, index) in this.types"
                  :key="index"
                  @click="type_click(index)">
                  <v-list-tile-title>{{ item[0]}}</v-list-tile-title>
                </v-list-tile>
              </v-list>
          </v-menu>
          <v-menu v-if="type !=='대분류 선택'"
            transition="slide-y-transition"
            bottom>
            <v-btn slot="activator" color="#607D8B" dark class="purple">
              {{thema1}}
            </v-btn>
            <v-list>
              <v-list-tile v-for="( index, item ) in this.types[thema_index][1]" :key="index" @click="thema1_click(item)">
                <v-list-tile-title>{{ item }}</v-list-tile-title>
              </v-list-tile>
            </v-list>
          </v-menu>
          <v-btn icon><v-icon v-if="click_thema" @click="informLocate(city,type,thema1);">search</v-icon></v-btn>
          </p>
          <v-btn color="pink" dark @click="setWeather()"><v-icon left>brightness_5</v-icon>날씨</v-btn>
          <p>미세먼지에 따라 대전의 관광지를 추천해 드릴까요?
          <v-btn color="indigo" @click="informDust(city)" dark><v-icon left>cloud</v-icon>미세먼지</v-btn></p>
          <v-btn color="black" dark><v-icon left>add_to_queue</v-icon>병원</v-btn>
        </v-flex>
        </v-layout>
      </v-container>
      <template class="font_notable image" v-if="this.trip_inform.length">
        <paginated-list :list-array="this.trip_inform" />
      </template>
      <div style="height: 400px;" v-if="load === true">
        <div class="semipolar-spinner" :style="spinnerStyle" style="margin:100px auto;">
        <div class="ring"></div>
        <div class="ring"></div>
        <div class="ring"></div>
        <div class="ring"></div>
        <div class="ring"></div>
      </div>
    </div>
    </div>
    <div v-else>
      <h1 class="my-5 text-xs-center">여행중 페이지를 이용하려면 로그인을 하세요</h1>
    </div>
</div>
</template>




<script>
import Map from '@/components/Map'
import Geolocation from '@/components/Geolocation'
import Traveling from '@/components/Traveling'
import PaginatedList from '@/views/PaginatedList'
  export default {
    name: 'Traveling',
    components : {
      Map,
      Geolocation,
      Traveling,
      PaginatedList,
    },
    data() {
      return{
        city: '대전',
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
        click_thema: false,
        click_type: '대분류 선택',
        trip_inform: {type:Object},
        click_thema1: '소분류 선택',
        type:'대분류 선택',
        thema1:'소분류 선택',
        thema_index:'',
        load: false,
        mise_inform : []
      }
    },
    methods : {
      setWeather() {
      },
      type_click(index){
      console.log(index)
      this.type=this.types[index][0]
      console.log(this.type)
      this.thema_index=index
      this.thema1="소분류 선택"
      },
      thema1_click(item){
        console.log(item)
        this.thema1=item
      },
      informLocate(area,type,thema1){
        this.load=true
        this.trip_inform=[]
        console.log(area,type)
        // var url='http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey='
        // var key='rbssLvuPaumnRlgRCPsgU5IeLlHAf5nHHGU8P3JVSYqJvgSFL8l%2FJbCYNE9zVd5Je%2BFoFlSBFo%2Fochd7h97a%2Fg%3D%3D'
        // var URL= url+key+'&MobileOS=ETC&MobileApp=AppTest&areaCode='
        //지역 선택할 경우
        if (area !== ''){
          for(let [key, value] of Object.entries(this.areas)){
            //선택한 지역 분류data에서 번호 불러오기
            if(area === value){
              var spring_url = 'http://192.168.31.84:8080/api/post/areacode/'+key
              axios.get(spring_url).then((res)=>{
                console.log(1)
                console.log(res)
                //테마 선택안하고 지역만 선택할 경우
                if(type === '대분류 선택'){
                  this.trip_inform=res.data
                  this.load=false
                  console.log(this.trip_inform)
                  PaginatedList.props.pageNum.type=0
                } else if(type !== '대분류 선택'){ //지역선택후 테마 선택
                  for(let [key1, value] of Object.entries(this.types)){
                    //테마 분류된 테이블중에서 선택한 테마의 번호를 가져오기 위함
                    if(type === value[0]){
                      console.log(type)
                      var list_restype=[] //리스트에 저장해서 뿌려줄 data에 저장
                      for ( var [index,res_type] of Object.entries(res.data) ){
                        //선택한 테마 번호와 data 테마id와 같은 것 불러오기
                        if (res_type.content_type_id === Number(key1)){
                          if(thema1 === '소분류 선택')
                            {list_restype.push(res_type)
                            this.load=false} //리스트 저장
                          else if(thema1 !== '소분류 선택'){
                            console.log(this.types[key1][1][thema1])
                            if(this.types[key1][1][thema1] === res_type.cat2){
                              list_restype.push(res_type)
                              this.load=false
                            }
                          }
                        }
                      }//리스트저장for문
                      console.log(list_restype)
                      this.trip_inform=list_restype //뿌려줄 vue data에 저장한다.
                      this.load=false
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
        } else if(area === '대분류 선택'){ //지역 선택안할 경우, 선택하라고 알람
          alert('테마를 선택 안하셨네요! 지역기반으로 추천해드려요~')
        }
      },
      informDust(city){
        //pm25Grade1h = { 1: '좋음', 2: '보통', 3: '나쁨', 4: '매우나쁨'} //1시간마다 미세먼지,
        var table = { 0: '매우좋음', 1: '좋음', 2: '보통', 3: '나쁨', 4: '매우나쁨'}
        var data = [0,1,2,3,4]
        console.log(city)
        this.click_thema = false
        var url = 'http://192.168.31.84:8080/api/FindDust/' + city
        axios.get(url).then((res)=>{
          console.log(res.data)
          console.log(res.data.length)
          var num10 = 0
          var num25 = 0
          for(var [index,informs] of Object.entries(res.data)){
            num10 += informs.pm25Grade1h
            num25 += informs.pm10Grade1h
          }
          num10 = num10 / res.data.length
          num25 = num25 / res.data.length
          console.log('미세',num10,'초미세',num25)
          var near10 = 0;
          var abs10 = 0;
          var min10 = 100;
          var near25 = 0;
          var abs25 = 0;
          var min25 = 100;
          for (var i = 0; i < data.length; i++){
            abs10 = ((data[i] - num10) < 0) ? -(data[i] - num10) : (data[i] - num10);
            if (abs10 < min10){
              min10 = abs10; //MIN
              near10 = data[i] //near : 가까운값
            }
          }
          for (var i = 0; i < data.length; i++){
            abs25 = ((data[i] - num25) < 0) ? -(data[i] - num25) : (data[i] - num25);
            if (abs25 < min25){
              min25 = abs25; //MIN
              near25 = data[i] //near : 가까운값
            }
          }
          console.log(table[near10],table[near25])
          this.mise_inform.push({
            pm10: near10,
            pm25: near25,
            pm10_s: table[near10],
            pm25_s: table[near25],
          })
          console.log(this.mise_inform)
        })//axios 미세먼지
      },//informDust함수
    },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
