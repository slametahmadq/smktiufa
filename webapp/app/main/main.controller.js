'use strict';

angular.module('yamahaApp').controller('MainCtrl', function ($state) {
	$state.go('backend.dashboard');
});
