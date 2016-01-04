'use strict';

angular.module('yamahaApp').factory('Dashboards', function (Restangular) {
	return {
		metrics: Restangular.service('actuator/metrics')
	};
});
