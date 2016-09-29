app.controller('headerController',function($scope,$rootScope,$location,$state) {





    $scope.changePage1 = function() {

        $state.go("login");


    }
    $scope.changePage2 = function() {
        $state.go("register");

    }

});