<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Form With Spring Mvc Example</title>
<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
				<legend>Availiable Rooms</legend>
				    <table class="table table-striped">
					    <tr>
					    	<td>Number</td>
					    	<td>Type</td>
					    	<td>Price</td>
							<td>Offer</td>
					    </tr>
						<c:forEach items="${roomsList}" var="room">
							<tr>
								<td>${room.getNumber()}</td>
								<td>${room.getType()}</td>
								<td>${room.getPrice()}</td>
								<form:form><td><button name="bookButton" class="btn btn-success btn-custom" value=${room.getNumber()}>Book</button></td></form:form>
							</tr>
						</c:forEach>
    				</table>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>