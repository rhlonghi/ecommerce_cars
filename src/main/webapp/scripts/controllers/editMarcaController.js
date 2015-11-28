

angular.module('ecommercecars').controller('EditMarcaController', function($scope, $routeParams, $location, MarcaResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.marca = new MarcaResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Marcas");
        };
        MarcaResource.get({MarcaId:$routeParams.MarcaId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.marca);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.marca.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Marcas");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Marcas");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.marca.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});