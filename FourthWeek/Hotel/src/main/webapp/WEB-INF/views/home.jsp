<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
				<legend>Employee Details</legend>
				    <table class="table table-striped">
					    <tr>
					    	<td>First Name</td>
					    	<td>Last Name</td>
					    	<td>Email</td>
					    </tr>
					    <tr>
				    	<td>${employee.firstName}</td>
				    	<td>${employee.lastName}</td>
				    	<td>${employee.email}</td>
				    </tr>
    				</table>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>
