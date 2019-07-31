<template lang="html">
 <div>
   <button type="button" @click="searchFinedust">보기</button>
   <div v-if='view === true'>
     <p>먼지 : {{ dust }}</p>
   </div>
 </div>
</template>
<script>

export default {
 name: "Finedust",
 data() {
   return {
     view: false,
     dust: []
   }
 },
 methods: {
   searchFinedust: function() {

     // var xhr = new XMLHttpRequest();
     // xhr.onreadystatechange = function() {
     //     if (xhr.readyState === xhr.DONE) {
     //         if (xhr.status === 200 || xhr.status === 201) {
     //             console.log(xhr.responseText);
     //         } else {
     //             console.error(xhr.responseText);
     //         }
     //     }
     // };
     // xhr.open('GET', URL);
     // xhr.send();
     // xhr.open('GET', 'http://localhost:8080/#/tour_views');
     // xhr.send();

     const key = "rbssLvuPaumnRlgRCPsgU5IeLlHAf5nHHGU8P3JVSYqJvgSFL8l%2FJbCYNE9zVd5Je%2BFoFlSBFo%2Fochd7h97a%2Fg%3D%3D&ver=1.3"
     const BASE_URL = `http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?sidoName=대전&pageNo=1&numOfRows=10&ServiceKey=${key}&_returnType=json`
     const URL = BASE_URL
     // axios.defaults.baseURL = URL
     // axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
     // axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
     // console.log(URL)

     axios.get(URL).then(function(res){
       console.log(res)
     })
     .catch(function (error) {
       console.log(error);
     });

   },
 },
}
</script>
