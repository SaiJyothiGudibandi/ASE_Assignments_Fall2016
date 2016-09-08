app.controller('LoginController',function($scope,$rootScope,$location,$state) {
    $scope.continueMsg=true;
    var flag;

    $scope.submitForm = function(isValid) {



        //$scope.submitted = true;
        if (isValid) {
            console.log(localStorage.getItem("Student_details"));
            var details=localStorage.getItem("Student_details");
            details=JSON.parse(details);
            console.log(details);
            for(var i =0;i<details.length;i++) {
                var y = JSON.parse(details[i]);

                console.log(y.email_Address);
                if (y.email_Address === $("#emailAddressEP").val() && y.password_pass === $("#password").val()) {
                    flag = true;
                    //$state.go("home");

                }
                else{
                    flag=false;
                }
            }
            if(flag==true)
            {
                $state.go("home");
            }
            else
            {
                $scope.continueMsg=false;
            }


        }

    };

});