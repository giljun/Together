<template>
    <div id="dmap" class="map_wrap">
        <div class="hAddr">
            <span class="title">지도중심기준 행정동 주소정보</span>
            <span id="centerAddr"></span>
            <p>Lat = {{lat}} Lon = {{lon}}</p>
        </div>
        <div id="map" style="width:600px;height:400px;"></div>
        <!-- <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div> -->
    </div>
</template>

<script>
export default {
    name:'dmap',
    data(){
        return{
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
        showPosition: function (position) {
            this.lat = position.coords.latitude;
            this.lon = position.coords.longitude;
            return this.setMap(this.lat,this.lon);
        },
        setMap(lat,lon) {
            console.log(lat,lon)

            var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
            var mapOption = {
                center: new kakao.maps.LatLng(lat,lon), // 지도의 중심좌표
                // center: new kakao.maps.LatLng(37.711932, 128.788047),
                // center: new kakao.maps.LatLng(this.lat,this.lon),
                level: 5 // 지도의 확대 레벨
            };
            var map = new kakao.maps.Map(mapContainer, mapOption); 
            
            var geocoder = new kakao.maps.services.Geocoder();
            
            var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
                infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
                
            // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
            searchAddrFromCoords(map.getCenter(), displayCenterInfo);
            
            // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
            kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
                searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
                    if (status === kakao.maps.services.Status.OK) {
                        var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
                        detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
                        
                        var content = '<div class="bAddr">' + '<span class="title">법정동 주소정보</span>' + detailAddr + '</div>';
                        
                        // 마커를 클릭한 위치에 표시합니다 
                        marker.setPosition(mouseEvent.latLng);
                        
                        marker.setMap(map);
                        
                        // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                        infowindow.setContent(content);
                        infowindow.open(map, marker);
                    }
                });
            });
            
            // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
            kakao.maps.event.addListener(map, 'idle', function() {
                searchAddrFromCoords(map.getCenter(), displayCenterInfo);
            });
            
            function searchAddrFromCoords(coords, callback) {
                // 좌표로 행정동 주소 정보를 요청합니다
                geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
            }
            
            function searchDetailAddrFromCoords(coords, callback) {
                // 좌표로 법정동 상세 주소 정보를 요청합니다
                geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
            }
        
            // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
            function displayCenterInfo(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    var infoDiv = document.getElementById('centerAddr');
                    
                    for(var i = 0; i < result.length; i++) {
                        // 행정동의 region_type 값은 'H' 이므로
                        if (result[i].region_type === 'H') {
                            infoDiv.innerHTML = result[i].address_name;
                            console.log(infoDiv.innerHTML)

                            if(infoDiv.innerHTML[2] == '특' || infoDiv.innerHTML[2] == '광') {
                                console.log(infoDiv.innerHTML[0]+infoDiv.innerHTML[1])
                                infoDiv.innerHTML = infoDiv.innerHTML[0]+infoDiv.innerHTML[1];
                                // 서울 인천 대전 대구 광주 부산 울산 세종 제주
                            } else if(infoDiv.innerHTML[2] == '도') {
                                console.log(infoDiv.innerHTML[0]+infoDiv.innerHTML[1])
                                infoDiv.innerHTML = infoDiv.innerHTML[0]+infoDiv.innerHTML[1];
                                // 경기 강원
                            } else if(infoDiv.innerHTML[3] == '도') {
                                console.log(infoDiv.innerHTML[0]+infoDiv.innerHTML[2])
                                infoDiv.innerHTML = infoDiv.innerHTML[0]+infoDiv.innerHTML[2];
                                // 충북 충남 경북 경남 전북 전남
                            }
                            break;
                        }
                    }
                }
            }
        }
    },
    mounted(){
        this.myFunction()
        // this.setMap()
    }
}
</script>

<style>
    /* .map_wrap {position:relative;width:100%;height:350px;} */
    .title {font-weight:bold;display:block;}
    /* .hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;} */
    #centerAddr {display:block;margin-top:2px;font-weight: normal;}
    .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
</style>