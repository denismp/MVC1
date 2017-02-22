<!DOCTYPE html>
<html ng-app="StudentApp"> 
<head> 
	<meta charset="UTF-8">
	<script src="/myapp/resources/js/angular/angular.js"></script> 
	<script src="/myapp/resources/js/studentform.js"></script> 
	<title>Students</title>
</head> 
<body ng-controller="StudentController as main"> 
	<div> 
		<p><button ng-click="main.model.getStudents()">Get Students</button></p>
		<ul>
			<li ng-repeat="student in main.model.students">	
				{{student.name}}		
			</li>
		</ul>
	</div> 
</body> 
</html>
