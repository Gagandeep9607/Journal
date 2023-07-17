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
<title>Login and Register For Journal</title>
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
<body style="margin : 7vw" id="infobody">
		<div id="wrapper">
			<h1 class="bookclub">Welcome !</h1>

			<div class="row gx-5 gx-xxl-5">
				<div class="col">
					<h2>Register to Create Your Own Journal</h2>
					<form:form action="/register" method="post" modelAttribute="newUser">
					
						<form:errors class="text-danger" path="firstName" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="fNameInput" path="firstName" placeholder="#" />
							<form:label path="firstName" for="fNameInput">First Name : </form:label>
						</div>
						
						<form:errors class="text-danger" path="lastName" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="lNameInput" path="lastName" placeholder="#" />
							<form:label path="lastName" for="lNameInput">Last Name : </form:label>
						</div>
						
						<form:errors class="text-danger" path="email" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="emailInput" type="email" path="email" placeholder="#" />
							<form:label path="email" for="emailInput">Email : </form:label>
						</div>
						
						<form:errors class="text-danger" path="password" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="passInput" type="password" path="password" placeholder="#" />
							<form:label path="password" for="passInput">Password : </form:label>
						</div>
						
						<form:errors class="text-danger" path="confirm" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="confirmInput" type="password" path="confirm" placeholder="#" />
							<form:label path="confirm" for="confirmInput">Confirm Password : </form:label>
						</div>
						
						<button class="btn btn-success">Register</button>
					</form:form>
				</div>
					
			
				<div class="col">
					<h2>Login</h2>
					<form:form class="form-floating mb-3" action="/login" method="post" modelAttribute="newLogin">
						<form:errors class="text-danger" path="email" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="emailInput"  path="email" placeholder="#" />
							<form:label path="email" for="emailInput">Email : </form:label>
						</div>
						
						<form:errors class="text-danger" path="password" />
						<div class="form-floating mb-3">
							<form:input class="form-control" id="passInput" type="password" path="password" placeholder="#" />
							<form:label path="password" for="passInput">Password : </form:label>
						</div>
						
						<button class="btn btn-success">Login</button>
				   </form:form>
			
				</div>
			</div>
		</div>
		
		
</body>
</html>