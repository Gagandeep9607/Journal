<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Journal Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body id="dashbody" >


	
	<div id="dash1">
			<div id="dash2" align="right"><a href="/logout" >Logout</a></div>
				<h1 align="center">${user.firstName}'s Personal Journal</h1>
				<h3>Welcome <span id="dash3">${user.firstName}</span></h3>
	</div>

	<div style="margin : 5vw" id="dash4">
    
	   <c:catch>
	   <c:forEach var="information" items="${informations}">
				<c:if test="${user == information.user}">
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1" >Profession : : </span></div>
							<div class="divhead2"><c:out value="${information.profession}"/></div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">My Hobbies : : </span></div>
							<div class="divhead2"><c:out value="${information.hobby}"/></div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Favorite Color : : </span></div>
							<div class="divhead2"><c:out value="${information.color}"/></div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Favorite Animal : : </span></div>
							<div class="divhead2"><c:out value="${information.pet}"/></div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Contact : : </span></div>
							<div class="divhead2"><c:out value="${information.user.email}"/></div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Some words for myself : : </span></div>
							<div class="divhead2"><c:out value="${information.about}"/></div>
						</div>
						<hr>
						<div class="divcontent">
							<a href="/${information.id}/editinfo">Edit Information</a>
						</div>
						<hr>
					</c:if>
		</c:forEach>
		</c:catch>

	</div>
		
	<div style="margin : 7vw" id="lastdash">
	
		<div id="dash6" align="right">
			<a href="/addcontact" id="dash5">Add a new contact to the List</a>
			<table class="table table-striped table-bordered" id="dash7">
				<thead>
					<tr>
						<th><span class="font8" >Name</span></th>
					</tr>
				</thead>
				<tbody id="dash8">
					<c:forEach var="profile" items="${profiles}">
						<c:if test="${user == profile.user}">
						<tr id="tab4">
							<th id="tab5">
								<div id="divcontact">
									<div class="contacthead"><a href="/${profile.id}/contactdetail"><c:out value="${profile.name}"/></a></div> 
									<div id="contactedit"><a href="/${profile.id}/editcontact">Update</a> | <a href="/${profile.id}/deletecontact">Delete</a></div>
								</div>
							</th>
						</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div id="otherinfo2">
		<span class="font1" >See Other's Profiles Here : </span>
		<div class="otherinfo">
			
			<c:forEach var="information" items="${informations}">
				
					<a href="/${information.id}/userdetails"><c:out value="${information.user.firstName}"/> <c:out value="${information.user.lastName}"/></a><br>
				
			</c:forEach>
		</div>
	</div>
	
	</div>
	
	
	
	

</body>
</html>