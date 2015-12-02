angular.module('candyshop', [])
    .controller('candyController', function ($scope, $http) {

        $scope.candies = [];

        $scope.init = function () {
            $http.get('/candies').success(function (data) {
                $scope.candies = data;
            });
        };

        $scope.init();
    });