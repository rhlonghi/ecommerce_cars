angular.module('ecommercecars').factory('CarroResource', function($resource){
    var resource = $resource('rest/carros/:CarroId',{CarroId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});