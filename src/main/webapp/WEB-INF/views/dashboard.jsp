<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ronaq.model.User"%>
<!DOCTYPE html>
<html>
<head>
	<title>Ronaq | Dashboard</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Custom Theme files -->
	<link href="${pageContext.request.contextPath}/resources/css/dashboard/bootstrap4.css" type="text/css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/resources/css/dashboard/style4.css" type="text/css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/resources/css/dashboard/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons -->
	<!-- //Custom Theme files -->
	<!-- js -->
	 <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	

	<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Source+Sans+Pro:400,700,400italic,700italic' rel='stylesheet'
	 type='text/css'>
	 
	<style>
        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #212529;
            color: white;  
            padding-left: 30px;
            padding-top: 9px;
            padding-bottom: 8px;
            font-size: 14px;
            font-family: initial;
            text-align: center          
        }
       
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<%-- 
Username :
<%=session.getAttribute("username")%>

Password :
<%=session.getAttribute("password") %> --%>
<div class="space">
		<div class="services-agileits" id="services" style="margin-top:48px;margin-bottom:10px">
			<div class="container">
				<div class="tittle-agileinfo">
					
				</div>
				<div class="services-left">
					<h4 class="title">Account Information</h4>
					<div class="more">
						<a href="#" data-toggle="modal" data-target="#myModal"> Click here</a>
					</div>
				</div>
			</div>


			<!--//services-->


			<!-- modal-sign -->
			<div class="modal bnr-modal fade" id="myModal" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-dialog modal-md">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="logo" />
							</div>
							<div class="modal-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Particulars</th>
											<th>Amount</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Cheque</td>
											<td>23000</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Cash</td>
											<td>10000</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Cash</td>
											<td>45000</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="w3ls-section services">
				<div class="container">
					<div class="services-righta">
						<h4 class="title">Loan Information</h4>
						<div class="more">
							<a href="#" data-toggle="modal" data-target="#myModal1"> Click here</a>
						</div>
					</div>

				</div>
				<div class="modal bnr-modal fade" id="myModal1" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-dialog modal-md">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="logo" />
								</div>
								<div class="modal-body">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>Duration(months)</th>
												<th>Amount</th>
												<th>Return Amount</th>
												<th>Status</th>
												<th>Remark</th>
											</tr>
										</thead>
										<tbody>										
											<tr>
												<td>2</td>
												<td>2.5 Lakhs</td>
												<td>3 Lakhs</td>
												<td>Approved</td>
												<td>-</td>
											</tr>
											<tr>
												<td>2</td>
												<td>2.5 Lakhs</td>
												<td>3 Lakhs</td>
												<td>Approved</td>
												<td>-</td>
											</tr>
											<tr>
												<td>2</td>
												<td>2.5 Lakhs</td>
												<td>3 Lakhs</td>
												<td>Approved</td>
												<td>-</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/resources/js/dashboard/bootstrap4.js"></script>

<%@include file="footer.jsp"%> 
</body>
</html>