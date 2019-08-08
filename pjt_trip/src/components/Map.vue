<template>
  <div>
    <div id="map" style="width:700px;height:300px;"></div>
  </div>
</template>

<script>
import axios from 'axios'
import VueAxios from 'vue-axios'
import index from '@/views/index'
import Map from  '@/components/Map'
export default {
  name: 'dmap',
  components:{
    index,
    Map
  },
  data() {
    return {
      view: false,
      error: ''
    }
  },
  props:{
    lat:{type:String},
    lon:{type:String},
  },
  methods: {
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
    },
    setMap(){
      navigator.geolocation.getCurrentPosition(function(position) {
        // this.lat=position.coords.latitude;
        // this.lon=position.coords.longitude;
        console.log(position.coords.latitude)
        var container = document.getElementById('map');
        var mapOptions = {
        // center: new daum.maps.LatLng(36.3549777,127.2961516),
        center: new daum.maps.LatLng( position.coords.latitude , position.coords.longitude),
        level: 5 //지도의 레벨(확대, 축소 정도)
        }
        var map = new daum.maps.Map(container, mapOptions);
      }, function(error) {
        console.error(error);
        }, {
          enableHighAccuracy: false,
          maximumAge: 0,
          timeout: Infinity
          });

    },
  },
  created() {
    this.setMap();
  }
};
</script>

<style scoped>

</style>
