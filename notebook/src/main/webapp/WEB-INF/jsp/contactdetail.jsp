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
<title>View Contact Details</title>
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
<body  id="infobody">

	<div id="dash1">
			<div id="dash2" align="right"><a href="/logout" >Logout</a> | <a href="/home">Dashboard</a></div>
				<h1 align="center">Personal Journal</h1>
	</div>
				<div style="margin : 7vw">
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1" >Name : : </span></div>
							<div class="divhead2">${profile.name}</div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Nick Name : : </span></div>
							<div class="divhead2">${profile.nickname}</div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Relation : : </span></div>
							<div class="divhead2">${profile.relation}</div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Contact : : </span></div>
							<div class="divhead2">${profile.contact}</div>
						</div>
						<hr>
						<div class="divcontent">
							<div class="divhead"><span class="font1">Address : : </span></div>
							<div class="divhead2">${profile.address}</div>
						</div>
						<hr>
				</div>
</body>
</html>