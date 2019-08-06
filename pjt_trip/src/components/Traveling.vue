<template>
  <div class="travel">
    <h1 class="my-5 text-xs-center">여행중</h1>

    <v-container fluid grid-list-xl>
      <v-layout wrap align-center>
        <v-flex xs6 sm2 d-flex>
          <v-select :items="sido" label="광역시도" v-model="city" v-on:change="setgu()"></v-select>
        </v-flex>

        <v-flex xs6 sm2 d-flex>
          <v-select :items="items" label="시군구"></v-select>
        </v-flex>

        <v-flex xs12 sm4 d-flex>
          <v-select :items="items" label="읍면동"></v-select>
        </v-flex>
      </v-layout>

      <v-layout wrap align-center>
        <v-btn color="pink" dark @click="setWeather()">
          <v-icon left>brightness_5</v-icon>날씨
        </v-btn>
        <v-btn color="indigo" dark>
          <v-icon left>cloud</v-icon>미세먼지
        </v-btn>
        <v-btn color="black" dark>
          <v-icon left>local_hospital</v-icon>병원
        </v-btn>
      </v-layout>

      <br />
      <br />

      <v-layout wrap align-center>
        <Map></Map>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;미세먼지 ~~~
        <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;날씨 ~~~~~~~
        <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;병원 ~~~~~~~~
      </v-layout>

      <!-- <template>
      <v-card max-width="1000" class="mx-auto">-->
      <!-- <v-card-title>I'm a title</v-card-title>
          <v-card-text>I'm card text</v-card-text>
          <v-card-actions>
            <v-btn text>Click</v-btn>
      </v-card-actions>-->
      <!-- <Map></Map> -->
      <!-- <br>
        </v-card>
      </template>-->

      <!-- <template>
        <div>
          <Geolocation></Geolocation>
        </div>
      </template>-->
    </v-container>
  </div>
</template>

<script>
import Map from '@/components/Map'
import Geolocation from '@/components/Geolocation'

export default {
  components: {
    Map,
    Geolocation
  },
  data () {
    return {
      sido: ['서울', '경기', '인천', '대전', '충북', '충남', '광주', '전북', '전남', '대구', '경북', '울산', '부산', '경남', '강원', '제주'],
      items: ['Foo', 'Bar', 'Fizz', 'Buzz'],
      city: ''
    }
  },
  methods: {
    setgu () {
      if (this.city === '서울') {
        this.items = ['강남구', '강동구', '강북구', '강서구', '관악구', '광진구', '구로구', '금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구', '서초구', '성동구', '성북구', '송파구', '양천구', '영등포구', '용산구', '은평구', '종로구', '중구', '중랑구']
      } else if (this.city === '경기') {
        this.items = ['가평군', '고양시 덕양구', '고양시 일산동구', '고양시 일산서구', '과천시', '광명시', '광주시', '구리시']
      }
    },
    setWeather () {

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
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
