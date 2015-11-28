'use strict';

angular.module('ecommercecars',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Carros',{templateUrl:'views/Carro/search.html',controller:'SearchCarroController'})
      .when('/Carros/new',{templateUrl:'views/Carro/detail.html',controller:'NewCarroController'})
      .when('/Carros/edit/:CarroId',{templateUrl:'views/Carro/detail.html',controller:'EditCarroController'})
      .when('/Categoria',{templateUrl:'views/Categoria/search.html',controller:'SearchCategoriaController'})
      .when('/Categoria/new',{templateUrl:'views/Categoria/detail.html',controller:'NewCategoriaController'})
      .when('/Categoria/edit/:CategoriaId',{templateUrl:'views/Categoria/detail.html',controller:'EditCategoriaController'})
      .when('/Items',{templateUrl:'views/Item/search.html',controller:'SearchItemController'})
      .when('/Items/new',{templateUrl:'views/Item/detail.html',controller:'NewItemController'})
      .when('/Items/edit/:ItemId',{templateUrl:'views/Item/detail.html',controller:'EditItemController'})
      .when('/Marcas',{templateUrl:'views/Marca/search.html',controller:'SearchMarcaController'})
      .when('/Marcas/new',{templateUrl:'views/Marca/detail.html',controller:'NewMarcaController'})
      .when('/Marcas/edit/:MarcaId',{templateUrl:'views/Marca/detail.html',controller:'EditMarcaController'})
      .when('/Modelos',{templateUrl:'views/Modelo/search.html',controller:'SearchModeloController'})
      .when('/Modelos/new',{templateUrl:'views/Modelo/detail.html',controller:'NewModeloController'})
      .when('/Modelos/edit/:ModeloId',{templateUrl:'views/Modelo/detail.html',controller:'EditModeloController'})
      .when('/Usuarios',{templateUrl:'views/Usuario/search.html',controller:'SearchUsuarioController'})
      .when('/Usuarios/new',{templateUrl:'views/Usuario/detail.html',controller:'NewUsuarioController'})
      .when('/Usuarios/edit/:UsuarioId',{templateUrl:'views/Usuario/detail.html',controller:'EditUsuarioController'})
      .when('/Vendas',{templateUrl:'views/Venda/search.html',controller:'SearchVendaController'})
      .when('/Vendas/new',{templateUrl:'views/Venda/detail.html',controller:'NewVendaController'})
      .when('/Vendas/edit/:VendaId',{templateUrl:'views/Venda/detail.html',controller:'EditVendaController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
