<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alignment questionnaire</title>
<style>
#mainbackground {
	background- background-size: cover;
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

</head>
<body>
	<!--<canvas id="bgCanvas"></canvas>-->
	<canvas id="bgCanvas"></canvas>
	<canvas id="terCanvas"></canvas>

	<div class="container-fluid .smooth-scroll">
		<div class="row" style="height: 5vh">

			<div style="font-family: Lato">&nbsp;</div>

		</div>
		<div class="row" style="height: 66vh">
			<div class="col-2 bootstrapcolumn"></div>
			<div class="col-8 bootstrapcolumn">
				<div id="mainbackground"
					style="background-image: url('${location.backgroundUrl}');">
					<div class="someDivOverlay">
						<div class="row " style="height: 45vh">

							<div class="col-12 bootstrapmaincolumn wth centeredtext ">
								<strong>${location.name}</strong><br>
								<p id="maintext">${location.description}</p>
							</div>

						</div>
						<div class="row" style="height: 15vh">

							<div class="col-6 bootstrapmainbottomcolumnleft centeredtext ">
								<p id="choices">${location.firstChoice}</p>
							</div>


							<div class="col-6 bootstrapmainbottomcolumnright centeredtext ">
								<p id="choices">${location.secondChoice}</p>
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
			</div>
			<div class="col-2 bootstrapcolumn"></div>
		</div>


	</div>


	<script src="resources/js/background.js"></script>

</body>
</html>