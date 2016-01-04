'use strict';

angular.module('yamahaApp').config(function(validationSchemaProvider) {
	var roleValidator = {
		name: {
			'validations': 'required, minlength=4',
			'validate-on': 'blur',
			'messages': {
				'required': {
					'error': 'Name cannot be blank',
					'success': 'Ok'
				},
				'minlength': {
					'error': 'Must be longer than 3 character',
					'success': 'Ok'
				}
			}
		}
	};

	validationSchemaProvider.set('role', roleValidator);
});
