'use strict';

angular.module('yamahaApp').factory('Roles', function (Restangular) {
	return Restangular.service('roles');
});
