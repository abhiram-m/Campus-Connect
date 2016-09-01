<html>
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


<!-- Custom CSS -->
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.easing.1.3.min.js"></script>
<script type="text/javascript" src="scripts/scripts.js"></script>
<title>Student Registration</title>
</head>
<body>


	<!-- NAV BAR-->
	<jsp:include page="include/rnavbar.html" />

	<!-- NAV BAR-->

	<br>
	<br>
	<br>
	<div class="col-sm-5 form-box ">
		<div class="form-top center_div">
			<div class="form-top-left">
				<h3 style="color: white">Student - Sign up now</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<div class="form-bottom">
			<form role="form" action="SRegistration" method="post"
				class="registration-form center_div">
				<div class="form-group">
					<label style="color: white" class="" for="fname">First name</label>
					<input type="text" name="fname" placeholder="First name..."
						class="form-first-name form-control" id="form-first-name" required>
				</div>
				<div class="form-group">
					<label style="color: white" class="" for="lname">Last name</label>
					<input type="text" name="lname" placeholder="Last name..."
						class="form-last-name form-control" id="form-last-name" required>
				</div>
				<div class="form-group">
					<label style="color: white" class="" for="email">Email</label> <input
						type="text" name="email" placeholder="@albany.edu"
						class="form-email form-control" id="form-email" required> <p style="color: red">${error_email}</p> 
				</div>

				<div class="form-group">
					<label style="color: white" class="" for="dob">Date of
						Birth</label> <input type="date" name="dob" placeholder="mm-dd-yyyy"
						class="form-email form-control" id="form-email" required>
				</div>
				<div class="form-group">
					<label style="color: white" class="" for="sex">Gender</label> <br>
					<label style="color: white" class="radio-inline"><input
						type="radio" name="sex" value="male">Male</label> <label style="color: white"
						class="radio-inline"><input type="radio" name="sex" value="female">Female</label>

				</div>
				<div class="form-group">
					<label style="color: white" class="" for="pwd">Password</label> <input
						type="password" name="pwd" placeholder="Password"
						class="form-password form-control" id="form-password" required></input>
				</div>

				<div class="form-group">
					<label style="color: white" class="" for="major">Major</label> <select
						class="form-control" name="major">
						<option value="Computer Science">Computer Science</option>
						<option value="Performing Arts">Performing Arts</option>
						<option value="Physics">Physics</option>
						<option value="Biology">Biology</option>
					</select>

				</div>
				<div class="form-group">
					<label style="color: white" class="" for="classof">Class of</label>
					<input type="text" name="classof" placeholder="Class of..."
						class="form-last-name form-control" id="form-last-name" required>
				</div>
				<div class="form-group">
					<label style="color: white" class="" for="stuinterest">Field
						of Interest</label> <input type="text" name="stuinterest"
						placeholder="Interest..." class="form-email form-control"
						id="form-email" required>
				</div>

				<input type="submit" class="btn btn-lg btn-default"
					value="I'm Done!">
			</form>
		</div>
	</div>

	<!-- Academics form-->
	<div class="spacing"></div>
	<section id="login" class="content-section padbot"></section>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>
</html>