'use strict';

angular.module('yamahaApp').factory('Applications', function (Restangular) {
	return Restangular.service('applications');
});
