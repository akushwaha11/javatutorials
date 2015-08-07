<html>
	<head>
		<title>Create User</title>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	</head>

	<body>
		<form class="form-horizontal" role="form" ng-submit="addRowAsync()">
     <div class="form-group">
        <label class="col-md-2 control-label">First Name</label>
            <div class="col-md-4">
                 <input type="text" class="form-control" name="firstName"
                  ng-model="firstName" />
            </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label">Last Name</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="lastName"
                 ng-model="lastName" />
            </div>
    </div>
     <div class="form-group">
          <label class="col-md-2 control-label">Email</label>
             <div class="col-md-4">
                 <input type="text" class="form-control" name="email"
                  ng-model="email" />
             </div>
     </div>
     <div class="form-group">
           <div style="padding-left:110px">
              <input type="submit" value="Submit" class="btn btn-primary"/>
           </div>
     </div>
</form>
	<script type="text/javascript">
	var helloApp = angular.module("helloApp", ['ngResource']);
	 
	helloApp.config(['$httpProvider', function ($scope.addRowAsync = function(){
		// Add the data to the model
		//
		$scope.users.push({ 'firstName':$scope.firstName, 'lastName': $scope.lastName, 'email':$scope.email });
		// Writing it to the server
		//
		var data = 'firstName=' + $scope.firstName + '&amp;lastName=' + $scope.lastName + '&amp;email=' + $scope.email;
		$http.post('/user/add', data )
		.success(function(data, status, headers, config) {
		$scope.message = data;
		})
		.error(function(data, status, headers, config) {
		alert( "failure message: " + JSON.stringify({data: data}));
		});
		// Making the fields empty
		//
		$scope.firstName='';
		$scope.lastName='';
		$scope.email='';
		};$httpProvider) {    
		$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
	}]);
	
	
	</script>

	</body>
</html>