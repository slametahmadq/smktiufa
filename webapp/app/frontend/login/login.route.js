'use strict';

angular.module('yamahaApp').config(function ($stateProvider) {
	$stateProvider.state('login', {
		url: '/login',
		controller: 'LoginCtrl'
	});

	$stateProvider.state('logout', {
		url: '/logout',
		controller: 'LogoutCtrl'
	});
});
