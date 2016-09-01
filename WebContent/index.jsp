<%
//if (!session.isNew())
//	response.sendRedirect("NewsFeed");
%>

<!DOCTYPE html>
<html lang="en">

<head>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Campus Connect</title>



<!-- Custom CSS -->

<link href="CSS/indexstyle.css" rel="stylesheet" type="text/css">

<script src="scripts/scripts.js"></script>
<script type="text/javascript" src="scripts/jquery.easing.1.3.min.js"></script>
<link href="CSS/indexstyle.css" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">



</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<jsp:include page="include/navbar.html" />
<center>
<p style="color: green"> ${error_log} </p></center>
	<!-- Intro Header -->
	<header class="intro">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">

						<h1 class="brand-heading">Campus Connect</h1>
						<img src="CSS/images/MinervaTransp.png">
						<p class="intro-text">Get your campus life connected!.</p>
						<a href="#about" class="btn  page-scroll"> Know more! </a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- About Section -->
	<section id="about" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>About Campus Connect</h2>
				<p>
					Campus Connect (abbrv. C'C) is a Social Network built around the
					campus life limited to your University<br> Whole new features
					like <strong>Room mate finder and Student Market!</strong>
				</p>
			</div>
		</div>
	</section>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- login Section -->
	<section id="login" class="content-section text-center">
		<div class="row">
			<div class="container">
				<div class="col-lg-8 col-lg-offset-2">
					<h2>Login to C'C</h2>
					<div class="form-bottom">

						<jsp:include page="include/login.html" />
<p style="color: red">${login_error} </p>
					</div>

				</div>
			</div>
		</div>
	</section>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- Register Section -->
	<section id="register"
		class="container content-section text-center padbot">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>Register on C'C</h2>
				<p>
					Not yet registered?!! <br>Please click here to register
				</p>

				<ul class="list-inline banner-social-buttons">
					<li><a href="fregister.jsp" class="btn btn-default btn-lg">Faculty
							- Register Now!</a></li>
					<li><a href="sregister.jsp" class="btn btn-default btn-lg">Student
							Register Now!</a></li>

				</ul>
			</div>
		</div>
	</section>

	<!-- Map Section -->

	<!-- Footer -->
	<jsp:include page="include/footer.html" />

</body>

</html>
