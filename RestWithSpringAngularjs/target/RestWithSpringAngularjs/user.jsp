<html>
<head>
<title>User Details</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<style>
table,th,td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 5px;
}

table tr:nth-child(odd) {
	background-color: #f2f2f2;
}

table tr:nth-child(even) {
	background-color: #ffffff;
}
</style>
</head>
<body>
	<h2>User Details</h2>
	<div ng-app="mainApp" ng-controller="userController">
		<table border="0">
			<tr>
				<th>User id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Comments</th>
			</tr>
			<tr ng-repeat="user in users">
				<td>{{ user.userid }}</td>
				<td>{{ user.firstName }}</td>
				<td>{{ user.lastName }}</td>
				<td>{{ user.email }}</td>
				<td>{{ user.comment }}</td>
			</tr>
		</table>
	</div>
	<script>
		var mainApp = angular.module("mainApp", []);

		mainApp.controller('userController', function ($scope,$http) {
			
			var urlBase="http://localhost:8080/RestWithSpringAngularjs";			
			$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
			
			//get all tasks and display initially
			$http.get(urlBase+'/users').
		    	success(function(data) {
			        $scope.users = data;
			        
		    })});
		
		
				
	</script>
</body>
</html>