<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
   
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information Update</title>
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
	
	
	
	<div style="margin : 7vw" id="info1" align="center">
		<h2>Edit Information Here</h2>
		<form:form action="/${information.id}/editinfo" method="put" modelAttribute="information">
			<form:errors class="text-danger" path="profession" />
						<div class="form-floating mb-3" id="info2">
							<form:input class="form-control" id="professionInput" path="profession" placeholder="#" />
							<form:label path="profession" for="professionInput">Profession : </form:label>
						</div>
						
						<form:errors class="text-danger" path="hobby" />
						<div class="form-floating mb-3" id="info2">
							<form:input class="form-control" id="hobbyInput" path="hobby" placeholder="#" />
							<form:label path="hobby" for="hobbyInput">Hobby : </form:label>
						</div>
						
						<form:errors class="text-danger" path="color" />
						<div class="form-floating mb-3" id="info2">
							<form:input class="form-control" id="colorInput" path="color" placeholder="#" />
							<form:label path="color" for="colorInput">Favorite Color : </form:label>
						</div>
						
						<form:errors class="text-danger" path="place" />
						<div class="form-floating mb-3" id="info2">
							<form:input class="form-control" id="placeInput" path="place" placeholder="#" />
							<form:label path="place" for="placeInput">Favorite Place : </form:label>
						</div>
						
						<form:errors class="text-danger" path="pet" />
						<div class="form-floating mb-3" id="info2">
							<form:input class="form-control" id="petInput" path="pet" placeholder="#" />
							<form:label path="pet" for="petInput">Pets : </form:label>
						</div>
						
						<form:errors class="text-danger" path="about" />
						<div class="form-floating mb-3" id="info3">
							<form:textarea class="form-control" id="aboutInput" type="textarea" path="about" placeholder="#" />
							<form:label path="about" for="aboutInput">Tell us something interesting about yourself : </form:label>
						</div>
						
			<div align="center" class="info2">
				<input type="submit" value="Save" class="btn btn-success" id="infobutton"/>
			</div>
		</form:form>
	</div>
	
</body>
</html>