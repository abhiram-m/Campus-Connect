<html>
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
<script type="text/javascript" src="jquery-1.11.3.min.js"></script>


<!-- Custom css -->
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/scripts.js"></script>
<script type="text/javascript" src="scripts/jquery.easing.1.3.min.js"></script>
<body>


	<!-- NAV BAR-->
	<jsp:include page="include/rnavbar.html" />


	<!-- NAV BAR-->
	<br>
	<div style="color: white" id="error"></div>
	<!-- <form id="valid"> -->
		<br> <br> <br>

		<div class="col-sm-5 form-box ">
			<div class="form-top center_div">
				<div class="form-top-left">
					<h3 style="color: white">Faculty - Sign up now</h3>
					<p style="color: white"></p>
				</div>
				<div class="form-top-right">
					<i class="fa fa-pencil"></i>
				</div>
			</div>
			<div class="form-bottom">
				<form role="form" action="FRegistration" method="post"
					class="registration-form center_div">
					<div class="form-group">
						<label style="color: white" class="" for="ffname">First
							name</label> <input type="text" name="ffname" placeholder="First name..."
							class="form-first-name form-control" id="form-first-name"
							required>
					</div>
					<div class="form-group">
						<label style="color: white" class="" for="flname">Last
							name</label> <input id="lname" type="text" name="flname"
							placeholder="Last name..." class="form-last-name form-control"
							id="form-last-name" required>
					</div>
					<div class="form-group">
						<label style="color: white" class="" for="femail">Email</label> <input
							id="email" type="text" name="femail" placeholder="Email..."
							class="form-email form-control" id="form-email" required><p style="color: red">${error_email}</p>
					</div>

					<div class="form-group">
						<label style="color: white" class="" for="fdob">Date of
							Birth</label> <input type="date" name="fdob" placeholder="mm-dd-yyyy"
							class="form-email form-control" id="form-email" required>
					</div>
					<div style="color: white" class="form-group">
						<label style="color: white" class="" for="fsex">Gender</label> <br>
					<label style="color: white" class="radio-inline"><input
						type="radio" name="fsex" value="male">Male</label> <label style="color: white"
						class="radio-inline"><input type="radio" name="fsex" value="female">Female</label>

					</div>
					<div class="form-group">
						<label style="color: white" class="" for="fpwd">Password</label> <input
							type="password" name="fpwd" placeholder="Password"
							class="form-password form-control" id="form-password" required></input>
					</div>

					<div class="form-group">
						<label style="color: white" class="" for="department">Department</label><br>


						<select class="form-control" name="department">
							<option value="Computer Science">Computer Science</option>
							<option value="Performing Arts">Performing Arts</option>
							<option value="Physics">Physics</option>
							<option value="Biology">Biology</option>
						</select>




					</div>
					<div class="form-group">
						<label style="color: white" class="" for="courses">Courses
							Offered</label> <input type="text" name="courses"
							placeholder="Course Offered" class="form-last-name form-control"
							id="form-last-name">
					</div>
					<div class="form-group">
						<label style="color: white" class="" for="rarea">Research
							Area</label> <input type="text" name="rarea" placeholder="Research Area"
							class="form-email form-control" id="form-email">
					</div>
					<div class="form-group">
						<label style="color: white" class="" for="ohours">Office
							Hours</label> <input type="text" name="ohours" placeholder="Office Hours"
							class="form-email form-control" id="form-email">
					</div>
					<div class="form-group">
						<label style="color: white" class="" for="olocation">Office
							Location</label> <input type="text" name="olocation"
							placeholder="Office Location" class="form-email form-control"
							id="form-email">
					</div>

					<input type="submit" class="btn btn-lg btn-default page-scroll"
						value="I am Done!">
				</form>
			</div>
		</div>




		<!-- Academics form-->
		<div class="spacing"></div>
		<section id="login" class="content-section padbot"></section>

		<!-- Footer -->
		<jsp:include page="include/footer.html" />
</body>

<!-- <script>
	$("#valid").submit(function(event) {

		var error = "";

		event.preventDefault();

		if (!isValidEmailAddress($("#email").val())) {

			error = "<br> email address not valid";

		}

		if (!$.isNumeric($("#phone").val())) {

			error = error + "<br> phone number not valid";

		}

		if (error == "") {

			alert("Done!");

		} else {

			$("#error").html(error);
		}
	});

	function isValidEmailAddress(emailAddress) {
		var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
		return pattern.test(emailAddress);
	};
</script>
 -->
</html>