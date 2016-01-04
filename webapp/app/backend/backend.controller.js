'use strict';

angular.module('yamahaApp').controller('BackendCtrl', function ($state) {
	if ('backend' === $state.current.name) {
		$state.transitionTo('backend.dashboard');
	}
});
