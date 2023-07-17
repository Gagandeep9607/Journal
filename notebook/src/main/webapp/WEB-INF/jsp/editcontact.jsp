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
<title>Edit Contact Detail</title>
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
<body id="infobody">

	<div id="dash1">
			<div id="dash2" align="right"><a href="/logout" >Logout</a> | <a href="/home">Dashboard</a></div>
				<h1 align="center">Personal Journal</h1>
	</div>

	<div id="info1" align="center" style="margin : 7vw">
		<h2>Edit Contact details</h2>
		<form:form action="/${profile.id}/editcontact" method="put" modelAttribute="profile">
			<form:errors path="name" class="text-danger"></form:errors>
			<div class="form-floating mb-3" id="info2">
				<form:input class="form-control" id="nameInput" path="name" placeholder="#"/>
				<form:label path="name" for="nameInput">Enter Name of the Contact : </form:label>
			</div>
			
			<form:errors path="nickname" class="text-danger"></form:errors>
			<div class="form-floating mb-3" id="info2">
				<form:input path="nickname" class="form-control" id="nicknameInput" placeholder="#"/>
				<form:label path="nickname" for="nicknameInput">Nick Name for contact  : </form:label>	
			</div>
			
			<form:errors path="contact" class="text-danger"></form:errors>
			<div class="form-floating mb-3" id="info2">
				<form:input path="contact" class="form-control" id="contactInput" placeholder="#"/>
				<form:label path="contact" for="contactInput">Contact : </form:label>
			</div>
			
			<form:errors path="address" class="text-danger"></form:errors>
			<div class="form-floating mb-3" id="info2">
				<form:input path="address" class="form-control" id="addressInput" placeholder="#"/>
				<form:label path="address" for="addressInput">Address : </form:label>
			</div>
			
				<form:errors path="relation" class="text-danger"></form:errors>
			<div class="form-floating mb-3" id="info2">
				<form:input path="relation" class="form-control" id="relationInput" placeholder="#"/>
				<form:label path="relation" for="relationInput">Relation : </form:label>
			</div>

			<div align="center" class="info2">
				<input type="submit" value="Save Contact" class="btn btn-success" id="infobutton"/>
			</div>
		</form:form>
	</div>
	
</body>
</html>