'use strict';

angular.module('yamahaApp').config(function ($stateProvider) {
	$stateProvider.state('main', {
		url: '/',
		controller: 'MainCtrl'
	});
});
