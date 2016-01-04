'use strict'

angular.module('yamahaApp').factory('Newss', function(Restangular){
	return Restangular.service('news');
});