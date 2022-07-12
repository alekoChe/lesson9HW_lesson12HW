angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';
//angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $rootScope, $http, $localStorage) {
//    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadCart = function () {
            $http.get(contextPath + '/cart')
                .then(function (response) {
                    $scope.cartList = response.data;
            });
    };

    $scope.deleteProductFromCart = function (productId) {
                $http.get(contextPath + '/cart/delete_product/' + productId)
                    .then(function (response) {
                        $scope.loadCart();
                });
    }

    $scope.loadCart();

});