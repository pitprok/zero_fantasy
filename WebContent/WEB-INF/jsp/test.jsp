<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	background: rgba(255, 255, 255, 0.5)
}

.myDiv {
	position: relative;
	z-index: 1;
}

.myDiv .bg {
	position: absolute;
	z-index: -1;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: url('${location.backgroundUrl}') center center;
	opacity: .5;
	width: 100%;
	height: 100%;
	background-repeat:no-repeat;
}

#stats {
	background: rgba(70, 72, 82, 0.5);
	position: relative;
}

#statsTable {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#playerName {
	position: absolute;
	bottom: 55vh;
	text-align: center;
	font-size: calc(0.9vw + 0.9vh);
}

table.table-bordered>tbody>tr>th {
	border: 3px solid #800000;
	font-size: calc(0.9vw + 0.9vh)
}

table.table-bordered>tbody>tr>td {
	border: 3px solid #800000;
		font-weight: bold;
	font-size: calc(0.9vw + 0.9vh)
}

table.table-bordered>tbody>tr>#hitpointsRow {
	color: green;

}

table.table-bordered>tbody>tr>#attackRow {
	color: red;

}

table.table-bordered>tbody>tr>#armorRow {
	color: blue;

}

table.table-bordered>tbody>tr>#speedRow {
	color: yellow;

}

table.table-bordered>tbody>tr>#accuracyRow {
	color: silver;

}


</style>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.3.1.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/mainpage.css" rel="stylesheet" type="text/css" />
<link href='https://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<link href="resources/css/stats.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<!--<canvas id="bgCanvas"></canvas>-->
	<canvas id="bgCanvas"></canvas>
	<canvas id="terCanvas"></canvas>




	<div class="container-fluid .smooth-scroll">
		<div class="row" style="height: 5vh">

		<!--	<div style="font-family: Lato">&nbsp;</div>  -->

		</div>
		<div class="row" style="height: 66vh">
			<div class="col-3 bootstrapcolumn" id="stats">
				<p class="text-center" id="playerName">
					<strong>${player.username}</strong>
				</p>

				<table class="table table-bordered" id="statsTable">

					<tbody>
						<tr>
							<th scope="row">Hitpoints:</th>
							<td id="hitpointsRow">${player.hitpoints}</td>

						</tr>
						<tr>
							<th scope="row">Attack:</th>
							<td id="attackRow">${player.attack}</td>

						</tr>
						<tr>
							<th scope="row">Armor:</th>
							<td id="armorRow">${player.armor}</td>

						</tr>
						<tr>
							<th scope="row">Speed:</th>
							<td id="speedRow">${player.speed}</td>

						</tr>
						<tr>
							<th scope="row">Accuracy:</th>
							<td id="accuracyRow"}>${player.accuracy}</td>

						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-8 bootstrapcolumn">
				<div class="myDiv">
					<div class="bg"></div>
					<div class="row " style="height: 45vh">
						<div class="col-12 bootstrapmaincolumn  centeredtext ">
							<strong>${location.name}</strong><br>
							<p id="maintext">${location.description}</p>
						</div>
					</div>

					<div class="row" style="height: 15vh">
						<div class="col-6 bootstrapmainbottomcolumnleft centeredtext ">
							<p class="text-center" id="choices">${location.firstChoice}</p>
						</div>


						<div class="col-6 bootstrapmainbottomcolumnright centeredtext ">
							<p class="text-center" id="choices">${location.secondChoice}</p>
						</div>
					</div>

					<div class="row" style="height: 5vh">
						<div class="col-6 bootstrapmainbottomcolumnleft centeredtext ">
							<a href="${pageContext.request.contextPath}/advance?choice=A">
								<input id="button" type="button" value="Choose" />
							</a>
						</div>

						<div class="col-6 bootstrapmainbottomcolumnright centeredtext ">
							<a href="${pageContext.request.contextPath}/advance?choice=B">
								<input id="button" type="button" value="Choose" />
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-1 bootstrapcolumn"></div>
		</div>


	</div>


	<script src="resources/js/background.js"></script>

</body>
</html>