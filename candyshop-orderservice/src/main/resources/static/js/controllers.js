'use strict';

/* Controllers */

var candyshopControllers = angular.module('candyshopControllers', []);

candyshopControllers.controller('OrdersController', function ($scope, $http) {

    $scope.orders = [];

    $scope.init = function () {
        $http.get('/orders').success(function (data) {
            $scope.orders = data;
        });
    };

    $scope.init();
});

candyshopControllers.controller('CheckoutController', function ($scope, $routeParams, $http) {
    $scope.candy = {};
    $scope.amount = 1;
    $scope.username = '';
    $scope.message = undefined;
    $scope.error = undefined;

    $scope.submitted = false;

    $scope.init = function () {
        $http.get('/candies/' + $routeParams.candyId).success(function (data) {
            $scope.candy = data;
        });
    };

    $scope.order = function () {
        $http.post('/orders', {
            username: $scope.username,
            amount: $scope.amount,
            candyId: $scope.candy.id
        }).success(function (data) {
            $scope.submitted = true;
            $scope.error = undefined;
            $scope.message = 'You successfully ordered ' + $scope.amount + ' ' + $scope.candy.name;
        }).error(function (data) {
            $scope.error = data.message;
        });
    };

    $scope.init();
});