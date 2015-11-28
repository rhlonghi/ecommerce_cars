
angular.module('ecommercecars').controller('NewCarroController', function ($scope, $location, locationParser, CarroResource , CategoriaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.carro = $scope.carro || {};
    
    $scope.categoriaList = CategoriaResource.queryAll(function(items){
        $scope.categoriaSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("categoriaSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.carro.categoria = {};
            $scope.carro.categoria.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Carros/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        CarroResource.save($scope.carro, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Carros");
    };
});