'use strict';

angular.module('yamahaApp').factory('Registers', function (Restangular) {
	return Restangular.service('signup');
});
