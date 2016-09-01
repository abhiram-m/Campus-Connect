<%@ page import="java.util.*"%>
<%@page import="dataBase.AuthDAO"%>
<%@page import="model.GetRoomMateFeed"%>
<%@page import="model.FacultyProfile"%>

<%
if (session.isNew())
	response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html lang="en">
<script type="text/javascript">
	function showAjax() {
		var content = document.getElementById("showAjaxText").value;
		doAjax("showAjaxId", "ajax.do?content=" + content);
		document.getElementById("showAjaxId").style.display = "block";
	}
	function showClickText(obj) {
		document.getElementById("showAjaxText").value = obj.innerHTML;
		document.getElementById("showAjaxId").style.display = "none";
	}
</script>

<head>
<meta charset="utf-8">
<script type="text/javascript">
	function showAjax() {
		var content = document.getElementById("showAjaxText").value;
		doAjax("showAjaxId", "ajax.do?content=" + content);
		document.getElementById("showAjaxId").style.display = "block";
	}
	function showClickText(obj) {
		document.getElementById("showAjaxText").value = obj.innerHTML;
		document.getElementById("showAjaxId").style.display = "none";
	}
</script>
<script type="text/javascript" src="js/ajax.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Campus Connect</title>
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


<script src="scripts/scripts.js"></script>

<link href="CSS/style.css" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
</head>

<body class="feeding">


	<!-- Navigation -->
	<jsp:include page="include/fnavbar.html" />



	<br>
	<br>
	<br>

	<!--tabs-->




	<div class="container"></div>

	<ul class="nav nav-tabs">
		<li><a href=newsfeed.jsp class="tabbold">News Feed</a></li>
		<li ><a href="RoomMateFeed" class="tabbold">Roommate
				Finder</a></li>
		<li><a href="SMarketFeed" class="tabbold">Student
				Market</a></li>
<li class="active"><a href="facultysearch.jsp" class="tabbold">Faculty Search</a></li>
		<li><a href="TeamJobPortal.jsp" class="tabbold">Jobs</a></li>
	</ul>

	<div align="center">
	<p>
	<h3 style="color:white">Please tell us your interest:</h3></p>
	<form action="FacultySearchServlet" method="get">
	
	<input name="field">
	<input type="submit" value="search">
	
	</form>
	<% ArrayList<FacultyProfile> p = (ArrayList<FacultyProfile>)request.getAttribute("profile"); %>
	<%if(p!=null){ %>
	<br>
	<h3><span style="color:white">Faculty List:</span></h3>
	<%for(int i =0; i<p.size();i++){ %>
	<h5><a style="color:white" href="viewprofile.jsp?Email=<%=p.get(i).getFemail() %>">PROF. <%=p.get(i).getFname() %> <%=p.get(i).getLname() %></a></h5>
<%}} %>
</div>
	<!-- Footer -->
	<jsp:include page="include/footer.html" />

</body>

</html>