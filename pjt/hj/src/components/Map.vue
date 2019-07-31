<template>

  <div id="dmap">
    <h1>{{msg}}</h1>

    <button type="button" @click="myFunction()">Click Me</Button>
        <p>Lat = {{ lat }} Lon = {{ lon }}</p>
        <p>{{ error }}</p>

    <div id="map" style="width:400px;height:300px;"></div>

  </div>

  

</template>

<script>

  export default {
    name: 'dmap',
    data() {
      return {
        msg:"MAP",
        view: false,
        lat: '',
        lon: '',
        error: ''
      }
    },
    methods: {
        myFunction: function() {
          if(navigator.geolocation){
            navigator.geolocation.getCurrentPosition(this.showPosition);
          }else{
            this.error = "Geolocation is not supported."; 
          }
        },
        showPosition:function (position) {	
          this.lat = position.coords.latitude;
          this.lon = position.coords.longitude;
        }
    },
    mounted() {
      var container = document.getElementById('map');
        var mapOptions = {
            // center: new daum.maps.LatLng(36.3549777,127.2961516),
            center: new daum.maps.LatLng(this.lat,this.lon),
            level: 5 //지도의 레벨(확대, 축소 정도)
        };
        var map = new daum.maps.Map(container, mapOptions);
    }
};
</script>

<style scoped>

</style>