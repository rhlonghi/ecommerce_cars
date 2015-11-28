

angular.module('ecommercecars').controller('EditModeloController', function($scope, $routeParams, $location, ModeloResource , MarcaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.modelo = new ModeloResource(self.original);
            MarcaResource.queryAll(function(items) {
                $scope.marcaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.modelo.marca && item.id == $scope.modelo.marca.id) {
                        $scope.marcaSelection = labelObject;
                        $scope.modelo.marca = wrappedObject;
                        self.original.marca = $scope.modelo.marca;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Modelos");
        };
        ModeloResource.get({ModeloId:$routeParams.ModeloId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.modelo);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.modelo.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Modelos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Modelos");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.modelo.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("marcaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.modelo.marca = {};
            $scope.modelo.marca.id = selection.value;
        }
    });
    
    $scope.get();
});