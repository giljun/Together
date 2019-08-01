<template>

  <div id="dmap">
    <h1>{{msg}}</h1>

    <button type="button" @click="setMap()">Click Me</Button>
        <p>Lat = {{ lat }} Lon = {{ lon }}</p>
        <p>{{ error }}</p>

    <div id="map" style="width:400px;height:300px;"></div>

  </div>

</template>

<script>
import axios from 'axios'
import VueAxios from 'vue-axios'

export default {
  name: 'dmap',
  data() {
    return {
      msg:"MAP",
      view: false,
      lat: 0,
      lon: 0,
      error: ''
    }
  },
  methods: {
    myFunction: function() {
      if(navigator.geolocation){  
        navigator.geolocation.getCurrentPosition(this.showPosition);
      } else {
        this.error = "Geolocation is not supported.";
      }
    },

    showPosition:function (position) {	
      this.lat = position.coords.latitude;
      this.lon = position.coords.longitude;
      // alert(this.lat + " and " + this.lon);

      axios.post("http://192.168.31.68:8080/api/FindHospital/",
      { lat:this.lat, lon:this.lon }
      ).then(response => {
        console.warn(response)
        this.result = response.data
        // this.no = response.data.no
        console.log(response)
      }).catch((ex) => {
        console.warn("ERROR:", ex)
      })
      
      // this.axios.post("http://localhost:8080",lat, lon)
      // .then((response) => {
      //   console.log(response.data)
      // })


    },

    setMap() {
      var container = document.getElementById('map');
      var mapOptions = {
      // center: new daum.maps.LatLng(36.3549777,127.2961516),
      center: new daum.maps.LatLng(this.lat ,this.lon),
      level: 5 //지도의 레벨(확대, 축소 정도)
      }
      var map = new daum.maps.Map(container, mapOptions);
    }
  },

  mounted() {
    this.myFunction()
  }
};
</script>

<style scoped>

</style>