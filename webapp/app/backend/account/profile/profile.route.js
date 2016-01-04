'use strict';

angular.module('yamahaApp').config(function ($stateProvider) {
	$stateProvider.state('backend.profile', {
		url: '/account/profile',
		templateUrl: 'backend/account/profile/profile.html',
		controller: 'ProfileCtrl'
	});
});
