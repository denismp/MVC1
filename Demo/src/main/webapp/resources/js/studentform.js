"use strict"; 
angular.module('StudentApp',[]); 
angular.module('StudentApp').service('StudentModel', ['$http', function($http){ 
	this.students = [{name:"NONE"},{name:"NONE2"}];
	this.getStudents = function(){
		//alert("getStudents called.");
		$http.get('http://localhost:8080/myapp/students') 
		.then( function (response) { 
			this.students = response.data; 
		}.bind( this), function (response) { 
			console.log( response.data); 
		});		
	}
}]);
angular.module('StudentApp').controller('StudentController', ['StudentModel', function(StudentModel){ 
	this.model = StudentModel;
}]);