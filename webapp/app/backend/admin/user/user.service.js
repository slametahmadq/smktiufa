'use strict';

angular.module('yamahaApp').factory('Users', function (Restangular) {
	return Restangular.service('users');
});
