

angular.module('ecommercecars').controller('EditCarroController', function($scope, $routeParams, $location, CarroResource , CategoriaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.carro = new CarroResource(self.original);
            CategoriaResource.queryAll(function(items) {
                $scope.categoriaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.carro.categoria && item.id == $scope.carro.categoria.id) {
                        $scope.categoriaSelection = labelObject;
                        $scope.carro.categoria = wrappedObject;
                        self.original.categoria = $scope.carro.categoria;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Carros");
        };
        CarroResource.get({CarroId:$routeParams.CarroId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.carro);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.carro.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Carros");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Carros");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.carro.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("categoriaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.carro.categoria = {};
            $scope.carro.categoria.id = selection.value;
        }
    });
    
    $scope.get();
});