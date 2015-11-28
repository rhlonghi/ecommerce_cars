
angular.module('ecommercecars').controller('NewMarcaController', function ($scope, $location, locationParser, MarcaResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.marca = $scope.marca || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Marcas/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        MarcaResource.save($scope.marca, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Marcas");
    };
});