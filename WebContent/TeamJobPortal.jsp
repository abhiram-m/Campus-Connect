<%@ page import="java.util.*"%>
<%@page import="dataBase.AuthDAO"%>
<%@page import="model.GetRoomMateFeed"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
if (session.isNew())
	response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html lang="en">

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

<body class="feeding" onload="myfunction">


	<!-- Navigation -->
	<jsp:include page="include/fnavbar.html" />



	<br>
	<br>
	<br>

	<!--tabs-->




	<div class="container"></div>

	<ul class="nav nav-tabs">
		<li><a href=newsfeed.jsp class="tabbold">News Feed</a></li>
		<li><a href="RoomMateFeed" class="tabbold">Roommate
				Finder</a></li>
		<li><a href="SMarketFeed" class="tabbold">Student
				Market</a></li>
				<li><a href="facultysearch.jsp" class="tabbold">Faculty Search</a></li>
				
						<li class="active"><a href="TeamJobPortal.jsp" class="tabbold">Jobs</a></li>

	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">

			<!--tabs-->







			<!--NEWSFEEDS-->


			<!-- this is the wrapper for the content -->
			<div class="st-content">

				<!-- extra div for emulating position:fixed of the menu -->
				<div class="st-content-inner">

					<div class="container">


						<div class="row">
							<div class="col-md-9">
								<ul class="timeline-list">
<!-- Getting the user name  -->
<% String name=(String)session.getAttribute("name"); %>
		<!-- New post -->
				<div class="media-body">
											<div class="media-body-wrapper">
												<div class="row">
													<div class="col-md-10 col-lg-8">
														<div class="panel panel-default">
															<form action="TeamJobPortalServlet" method="post">
																<div class="panel-heading panel-heading-gray ">

																	Please fill out the form:</div>
																<div class="panel-body">
																<label class="radio-inline">Select Location : </label>
																		<input type="radio" name="location" value="oncampus">On Campus
																	 <label class="radio-inline"><input
																		type="radio" name="location" value="offcampus">Off Campus</label>
																	<br><label><div class="dropdown"></label><br>
																	  Select The Category:
																	   <br>
																	 <select name="category" id="type1" required>
																	   <option value="Default">Choose a Category</option>
																	   <option value="Computer Science">Computer Science</option>
																	   <option value="Management">Marketing and Management</option>
																	   <option value="Finance">Finance</option>
																	   <option value="Economics">Economics </option>
																	</select> 
																	  </div></label>
																	 <br> Job description <br>
																	<textarea name="description" id="description"
																		class="form-control" rows="3"
																		placeholder="Description of Job..." required></textarea>
																	<br> <label for="requirement">Requirement :</label> <input
																		type="text" class="form-control" id="add"
																		name="requirement" /> <br> <label for="requirement" required>Deadline Date:</label>
																	<input type="date"  id="date"
																		name="date" /><br>
																		<label >Apply at :</label>
																	<input type="text" id="url"
																		name="url"  /><br>
																		<label >Contact Email:</label>
																	<input type="email" class="form-control" id="contact"
																		name="email"  required>
																		<input type="hidden" name="pid" value="0">
																</div>
																<div class="panel-footer share-buttons">
																	<input type="submit"
																		class="btn btn-primary btn-xs pull-right "
																		name="action" class="btn btn-primary" value="Post" />
																</div>
															</form>
														</div>
													</div>
												</div>
												<div class="clearfix"></div>
											</div>

										</div>
									</li>
                     <!-- Previously Posted Content starts here -->
                     <h3>Posted Jobs:</h3>
                   
                   					<div class="media-body">
											<div class="media-body-wrapper">
												<div class="panel panel-default">

													<div class="panel-body">
														<p id="o">
														 <div>
      <script>
function myFunction() {
    var x = document.getElementById("mySelect").value;
    document.getElementById("filter").value = x;
   return x;
}
var v=myFunction();

</script>


            <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/campusconnect" user="root" password="manager" />



<c:set var="empId" value= "Id"/>
<sql:query dataSource="${snapshot}" var="result">
   SELECT * from jobportal order by deadlinedate  ;
   
   
</sql:query>



<c:forEach var="row" items="${result.rows}">
<tr>
<B>ID:</B>
<td><c:out value="${row.Id}"/></td>
<br><B>Location:</B>
<td><c:out value="${row.location}"/></td>
<br><B>Category:</B>
<td><c:out value="${row.category}"/></td>
<br><B>Description</B>
<td><c:out value="${row.description}"/></td>
<br><b>Requirement</b>
<td><c:out value="${row.requirement}"/></td>
<br><b>Deadline Date:</b>
<td><c:out value="${row.deadlinedate}"/></td>
<br><b>Apply at:</b>
<td><c:out value="${row.url}"/></td>
<br><b>Contact Us :</b> 
<td><c:out value="${row.email}"/></td>
<br><b>Posted by :</b> 
<td><c:out value="${row.owner}"/></td> (
<td><c:out value="${row.posteddate}"/></td>)<br>
</tr>
<br>
<br>
<br>
</c:forEach>


 </form>            
            
             
                
        </div>

														<div id="a"></div>
														<div id="d"></div>
														<div id="r"></div>
													</div>  



							

								</ul>

							</div>

						</div>
					</div>
				</div>
			</div>

			<!--CLOSING OF TABS-->
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />

</body>

</html>