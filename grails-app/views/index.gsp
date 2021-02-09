<%--
  Created by IntelliJ IDEA.
  User: emmac
  Date: 1/19/2021
  Time: 4:21 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="site"/>
    <title>Book Store Home</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
          integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
          crossorigin=""/>
    <!-- Make sure you put this AFTER Leaflet's CSS -->
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
            integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
            crossorigin=""></script>
</head>

<body>
<div class="jumbotron jumb-margin">
    <div class="container">
        <h1 class="text-center">Book Store</h1>
    </div>
</div>
<g:link controller="home" action="showTime" elementId="timeLink">Show the time!</g:link>
<div id="time"> time </div>
<div>Most Recent Book</div>
<div id="book"></div>

<p>Under construction</p>
<p>
    <g:link controller="controllerList">Go to ControllerList</g:link>
</p>

<!-- Simple get location -->
<p style="margin-top:20px"><button onclick="geoFindMe()" >Show my location</button></p>
<div id="latlong-out"></div>
<div id="mapid" style="height: 400px; width: 400px;"></div>

<asset:javascript src="geoloc.js"/>

</body>
</html>