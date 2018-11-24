<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alignment questionnaire</title>
<style>
.bootstrapcolumn {
	border: red solid 1px;
}

.centeredtext {
	text-align: center;
}

* {
	color: white;
}

body, html {
	background-color: #000;
	color: #fff;
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

canvas {
	position: absolute;
	top: 0;
	left: 0
}
</style>
</style>
</head>
<body>
	<canvas id="bgCanvas"></canvas>
	<canvas id="terCanvas"></canvas>

	<div class="container-fluid">
		<div class="row" style="height: 50px">
			<div class="col-xl-2 bootstrapcolumn"></div>
			<div class="col-xl-8 bootstrapcolumn centeredtext">Title</div>
			<div class="col-xl-2 bootstrapcolumn"></div>
		</div>
		<div class="row" style="height: 650px">
			<div class="col-xl-2 bootstrapcolumn"></div>
			<div class="col-xl-8 bootstrapcolumn">
				<div class="row " style="height: 250px">
					<div class="col-xl-12 bootstrapcolumn centeredtext">Question</div>
				</div>
				<div class="row" style="height: 400px">
					<div class="col-xl-6 bootstrapcolumn centeredtext">Action A</div>
					<div class="col-xl-6 bootstrapcolumn centeredtext">Action B</div>
				</div>
			</div>
			<div class="col-xl-2 bootstrapcolumn"></div>
		</div>
		<div class="row" style="height: 50px">
			<div class="col-xl-2 bootstrapcolumn"></div>
			<div class="col-xl-8 bootstrapcolumn"></div>
			<div class="col-xl-2 bootstrapcolumn"></div>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.js"
		integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
		crossorigin="anonymous"></script>

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script src="resources/js/background.js"></script>

</body>
</html>