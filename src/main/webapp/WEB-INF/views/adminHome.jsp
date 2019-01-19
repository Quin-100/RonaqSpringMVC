<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Ronaq | Admin Home Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">	  	   
	<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Source+Sans+Pro:400,700,400italic,700italic' rel='stylesheet' type='text/css'>

</head>
<body>

	<c:url var="addActionLogin" value="/login"></c:url>
	<c:url var="addActionLogout" value="/admin/logout"></c:url>
	<header id="header" style="background: #212529">
		<div class="container">
			<div class="logo" style="margin: -18px 0 0 15px">
				<a href="#"><img
					src="${pageContext.request.contextPath}/resources/images/logo.png"
					alt="Ronaq"></a>
			</div>
			<nav id="nav" style="background: 000 !important;">
				<div class="opener-holder">
					<a href="#" class="nav-opener"><span></span></a>
				</div>
				<% if(session.getAttribute("admindetails") == null){ %>

				<a href="${addActionLogin}" class="btn btn-primary rounded">Login</a>

				<% } else { %>

				<a href="${addActionLogout}" class="btn btn-primary rounded">Logout</a>

				<% } %>
				<div class="nav-drop">
					<ul>

					</ul>
				</div>
			</nav>
		</div>
	</header>
	<table class="table table-striped" id="customers">
		<thead>
			<tr>
				<th>Sr No</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Amount</th>
				<th>Return Amount</th>
				<th>Duration</th>
				<th>Status</th>	
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<c:set var="count" value="0" scope="page" />
		<c:if test="${!empty loanlst}">
			<c:forEach items="${loanlst}" var="loanlst">
				<tbody>
					<tr>
						<c:set var="count" value="${count + 1}" scope="page" />
						<c:set var="user" value="${user}"></c:set>
						<td><c:out value="${count}"></c:out></td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${loanlst.amount}</td>
						<td>${loanlst.returnamount}</td>
						<td>${loanlst.repaylimit}</td>
						<td>${loanlst.status}</td> 
						<td><a href="<c:url value='/approve/${loanlst.applicationId}' />"><button class="btn btn-success">Approve</button></a></td>
						<td><a href="<c:url value='/reject/${loanlst.applicationId}' />"><button class="btn btn-danger">Reject</button></a></td>
					</tr>
				</tbody>
			</c:forEach>
		</c:if>
		<c:if test="${empty loanlst}">
			<tbody>
				<tr>
					<td colspan="8">No loan application registered yet</td>
				</tr>
			</tbody>

		</c:if>
	</table>
<%@include file="footer.jsp" %>
</body>
</html>