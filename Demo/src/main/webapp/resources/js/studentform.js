"use strict"; 
angular.module('StudentApp',[]); 
angular.module('StudentApp').service('StudentModel', ['$http', function($http){ 
	this.students = [{name:"NONE"},{name:"NONE2"}];
	this.getStudents = function(){
		alert("getStudents called.");
		$http({method: 'GET', url: 'http://localhost:8080/myapp/students'}).
			then( function(data, status, headers, config){
				alert("Success!!");
				console.log( "Error: " + status );
				this.students = data;
			}).
			catch( function(data, status, headers, config){
				alert("Failed!!");
				console.log( "Error: " + status );
			});
//		$http.get('http://localhost:8080/myapp/students') 
//		.then( function (response) { 
//			this.students = response.data; 
//		}. bind( this), function (response) { 
//			console.log( response.data); 
//		});		
//		$http.get('http://localhost:8080/myapp/students')
//		.then(function(response){
//			alert( "in then");
//			alert( response.date );
//			this.students = response.data;
//		}.bind(this),function(response){
//			alert( "in bind" );
//			console.log(response.data);
//		});
//		alert(response.data);
	}
}]);
angular.module('StudentApp').controller('StudentController', ['StudentModel', function(StudentModel){ 
	this.model = StudentModel;
}]);
