<!DOCTYPE html>
<html ng-app="denisApp"> 
<head> 
	<meta charset="UTF-8">
	<script src="/myapp/resources/js/angular/angular.js"></script> 
	<script src="/myapp/resources/js/app.js"></script> 
	<title>Angular Examples</title>
</head> 
<body ng-controller="MainController as main"> 
	<div> 
		<p>Name: {{main.user.name}}</p> 
		<p>Favorite Fruit: {{main.user.favoriteFruit}}</p> 
		<p>Is Active? {{main.user.isActive}}</p> 
	</div> 
</body> 
</html>
