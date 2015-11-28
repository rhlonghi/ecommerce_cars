
angular.module('ecommercecars').controller('NewModeloController', function ($scope, $location, locationParser, ModeloResource , MarcaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.modelo = $scope.modelo || {};
    
    $scope.marcaList = MarcaResource.queryAll(function(items){
        $scope.marcaSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("marcaSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.modelo.marca = {};
            $scope.modelo.marca.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Modelos/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        ModeloResource.save($scope.modelo, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Modelos");
    };
});