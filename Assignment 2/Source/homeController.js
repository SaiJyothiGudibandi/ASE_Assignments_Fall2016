app.controller('googlemapoutput', function ($scope,$http) {

    var map;
    var mapOptions;
    var end;
    var start;
    var st1;
    var st2;
    $scope.fromCity=true;
    $scope.toCity=true;
    var directionsDisplay = new google.maps.DirectionsRenderer({
        draggable: true
    });
    var directionsService = new google.maps.DirectionsService();

    $scope.initialize = function () {
        var pos = new google.maps.LatLng(0, 0);
        var mapOptions = {
            zoom: 3,
            center: pos
        };

        map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);
    };
    $scope.calcRoute = function () {
        end = document.getElementById('endlocation').value;
        start = document.getElementById('startlocation').value;

        var request = {
            origin: start,
            destination: end,
            travelMode: google.maps.TravelMode.DRIVING
        };

        directionsService.route(request, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setMap(map);
                directionsDisplay.setDirections(response);
                console.log(status);
            }

        });
    };
    google.maps.event.addDomListener(window, 'load', $scope.initialize);

    $scope.getWeather = function() {
        st1=document.getElementById('state1').value;
        st2=document.getElementById('state2').value;
        $http.get('https://api.wunderground.com/api/36b799dc821d5836/conditions/q/' + st1 + '/' + start + '.json').success(function (data) {
            console.log(data);
            temp = data.current_observation.temp_f;
            icon = data.current_observation.icon_url;
            weather = data.current_observation.weather;
            console.log(temp);
            $scope.temp = temp;
            $scope.fromCity=false;
            $scope.currentweather = {
                html: "Currently " + temp + " &deg; F and " + weather + ""
            }
            $scope.currentIcon = {
                html: "<img src='" + icon + "'/>"
            }

        })

        $http.get('https://api.wunderground.com/api/36b799dc821d5836/conditions/q/' + st2 + '/' + end + '.json').success(function (data) {
            console.log(data);
            temp1 = data.current_observation.temp_f;
            icon1 = data.current_observation.icon_url;
            weather1 = data.current_observation.weather;
            console.log(temp1);
            $scope.temp1 = temp1;
            $scope.toCity=false;
            $scope.currentweather = {
                html: "Currently " + temp1 + " &deg; F and " + weather1 + ""
            }
            $scope.currentIcon = {
                html: "<img src='" + icon1 + "'/>"
            }

        })
    }



});
