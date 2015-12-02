'use strict';

/* App Module */

var candyshopApp = angular.module('candyshopApp', [
    'ngRoute',

    'candyshopControllers'
]);

candyshopApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/orders', {
            templateUrl: 'html/orders.html',
            controller: 'OrdersController'
        }).
        when('/checkout/:candyId', {
            templateUrl: 'html/checkout.html',
            controller: 'CheckoutController'
        }).
        otherwise({
            redirectTo: '/orders'
        });
    }]);