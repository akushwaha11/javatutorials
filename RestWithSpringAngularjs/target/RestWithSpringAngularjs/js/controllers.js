mainApp.controller('userController', function ($scope,$http) {

	var urlBase="http://localhost:8080/RestWithSpringAngularjs";			
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";

	//get all tasks and display initially
	$http.get(urlBase+'/users').
	success(function(data) {
		$scope.users = data;

	})});