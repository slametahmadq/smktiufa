'use strict';

angular.module('yamahaApp').directive('header', function ($rootScope) {
	return {
		restrict: 'E',
		link: function postLink(scope, element, attrs) {
			$rootScope.header = attrs.header;
			$rootScope.subheader = attrs.subheader;
		}
	};
});
