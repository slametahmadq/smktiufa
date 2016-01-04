'use strict'

angular.module('yamahaApp').config(function($stateProvider){
	$stateProvider.state('backend.barang', {
		url: '/backend/barang',
		templateUrl: 'backend/Barang/barang.html'
	});
});