<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="SpringForm"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alignment questionnaire</title>

<style>
#mainbackground {
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}
</style>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.3.1.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/mainpage.css" rel="stylesheet" type="text/css" />
<link href='https://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<link href="resources/css/stats.css" rel="stylesheet" type="text/css" />
<script src="<c:url value ="resources/js/angular.min.js"/>"></script>
<script src="<c:url value ="resources/js/angular-animate.js"/>"></script>
<script src="<c:url value ="resources/js/angular-route.js"/>"></script>
</head>
<body  ng-app="myApp">
	<!--<canvas id="bgCanvas"></canvas>-->
	<canvas id="bgCanvas"></canvas>
	<canvas id="terCanvas"></canvas>


	<div class="container-fluid .smooth-scroll" ng-controller="customersCtrl">

		<div class="row" style="height: 5vh"></div>
		<div class="row" style="height: 66vh">
			<div class="col-2 bootstrapcolumn">
				<div style="font-family: Lato">&nbsp;</div>
			</div>
			<div class="col-8 bootstrapcolumn" ng-repeat="x in myData">
				<div id="mainbackground"
					style="background-image: url('{{ x.backgroundUrl }}');">
					<div class="someDivOverlay">
						<div class="row " style="height: 45vh">

							<div class="col-12 bootstrapmaincolumn wth centeredtext ">
								<strong>{{ x.name }} </strong><br>
								<p id="maintext">{{ x.description }}</p>
							</div>

						</div>
						<div class="row" style="height: 15vh">

							<div class="col-6 bootstrapmainbottomcolumnleft centeredtext ">
								<p id="choices">{{ x.firstChoice }}<ul >
									<li >
                                </li>
                            </ul></p>
								
							</div>


							<div class="col-6 bootstrapmainbottomcolumnright centeredtext ">
								<p id="choices">{{ x.secondChoice }}</p>
							</div>
						</div>
						<div class="row" style="height: 5vh">

							<div class="col-6 bootstrapmainbottomcolumnleft centeredtext ">
								<input id="button" type="button" value="Choose" onclick="advanceA()" />
							</div>


							<div class="col-6 bootstrapmainbottomcolumnright centeredtext ">
								<input id="button" type="button" value="Choose" onclick="advanceB()" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-2 bootstrapcolumn"></div>
		</div>

	<div style="display:hidden" id="locationcode" > {{x.id}}</div>
	
	<script src="resources/js/background.js"></script>
	<script>
		var locationcode=$("#locationcode").innerHTML;	
		var app = angular.module('myApp', []);
		
		
		
		
	
			app.controller('customersCtrl', function($scope, $http) {
				$http.get("${pageContext.request.contextPath}/advance?locationcode=A").then(
						function(response) {
							$scope.myData = response.data;
						});
			});
		
		
		function advanceA(){
		app.controller('customersCtrl', function($scope, $http) {
			$http.get("${pageContext.request.contextPath}/advance?locationcode="+locationcode+"+A").then(
					function(response) {
						$scope.myData = response.data;
					});
		});
		}
		function advanceB(){
		app.controller('customersCtrl', function($scope, $http) {
			$http.get("${pageContext.request.contextPath}/advance?locationcode="+locationcode+"+B").then(
					function(response) {
						$scope.myData = response.data;
					});
		});
		}
	</script>

</div>

</body>
</html>