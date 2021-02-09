function geoFindMe() {
    var outputLatLong = document.getElementById("latlong-out");

    if (!navigator.geolocation){
        outputLatLong.innerHTML = "<p>Geolocation is not supported by your browser</p>";
        return;
    }

    function success(position) {
        var latitude = position.coords.latitude;
        var longitude = position.coords.longitude;

        outputLatLong.innerHTML = '<p>Latitude is ' + latitude + '° <br>Longitude is ' + longitude + '°</p>';

        // Add map
        var mymap = L.map('mapid').setView([latitude, longitude], 13);

        var tileURL = 'https://{s}.tile.thunderforest.com/transport-dark/{z}/{x}/{y}.png'
        var attribution = '&copy; <a href="http://www.thunderforest.com/">Thunderforest</a>, &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        var maxZoom = 19

        L.tileLayer(tileURL, {
            attribution: attribution,
            maxZoom: maxZoom
        }).addTo(mymap);
// end add map

        // Add marker
        var marker = L.marker([latitude, longitude], {
            draggable: true,  // set true to enable dragging the marker
            autoPan: false     // set true so the maps pans with the marker
        }).addTo(mymap)
// end add marker

        // Add listener for marker moved
        function onMarkerMove(e){
            marker.bindPopup("Marker at "+e.latlng.toString()).openPopup();
        }
        marker.on('move', onMarkerMove);
// end add listener


    };

    function error() {
        outputLatLong.innerHTML = "Unable to retrieve your location";
    };

    outputLatLong.innerHTML = "<p>Locating…</p>";
    navigator.geolocation.getCurrentPosition(success, error);

}