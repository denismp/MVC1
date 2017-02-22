"use strict"; 
angular.module('denisApp',[]); 
angular.module('denisApp').controller('MainController', [function(){ 
	this.user={ 
				name: 'John Smith',
				favoriteFruit: 'cherries', 
				isActive: true 
			};
}]);

