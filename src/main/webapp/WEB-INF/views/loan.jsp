<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Ronaq | Loan Types</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CVarela+Round" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loans/bootstrap.min.css" /> 
	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loans/styleb.css" />
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
<c:url var="addActionLogin" value="/login" ></c:url>
<c:url var="addActionLogout" value="/user/logout" ></c:url>
<header id="header" style="background: #212529">
			<div class="container">
				<div class="logo" style="margin: -18px 0 0 15px"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Ronaq"></a></div>
				<nav id="nav" style="background: 000 !important;">
					<div class="opener-holder">
						<a href="#" class="nav-opener"><span></span></a>
					</div>
					<% if(session.getAttribute("userdetails") == null){ %>
					
						<a href="${addActionLogin}" class="btn btn-primary rounded" >Login</a>
					
					<% } else { %>
						
						<a href="${addActionLogout}" class="btn btn-primary rounded" >Logout</a>
						
					<% } %>					
					<div class="nav-drop">
						<ul>
							<% if(session.getAttribute("userdetails") == null){ %>
					
								<li><a href="">Home</a></li>	
							
							<% } else { %>
								
								<li><a href="dashboard">Home</a></li>	
								
							<% } %>															
							<li><a href="aboutus">About Us</a></li>
							<li><a href="services">Services</a></li>
						</ul>						
					</div>
				</nav>
			</div>
 </header>
<header id="home">
		<!-- Background Image -->
		<div class="loan-img">  
			<div class="overlay">
			</div>
		</div>
		<!-- /Background Image -->
		<!-- home wrapper -->
		<div class="home-wrapper">
			<div class="container">
				<div class="row">

					<!-- home content -->
					<div class="col-md-10 col-md-offset-1">
						<div class="home-content">
							<h1 class="white-text">BIG DREAMS</h1>
							<h2 class="white-text">Even Bigger and Better Loans</h2>
						</div>
					</div>
					<!-- /home content -->

				</div>
			</div>
		</div>
		<!-- /home wrapper -->

	</header>
	<!-- /Header -->
	<!-- /Header -->
	<!-- Pricing -->
<!-- 	<a href="addloan">Add Lon type admin</a> -->
	<div id="pricing" class="section md-padding">

		<!-- Container -->
		<div class="container">

			<!-- Row -->
			<div class="row">
				<!-- pricing -->			
				<div class="col-sm-4">
					<div class="pricing">
						<div class="price-head">
							<span class="price-title">Educational Loan</span>
							<div class="price">
								<h3>10.5%<span class="duration">Interest Rate</span></h3>
							</div>
						</div>
						<ul class="price-content">
							<li>
								<p>₹10 lakhs Loan Amount</p>
							</li>
							<li>
								<p>Repay Limit 3 years</p>
							</li>
						</ul>
						<c:url var="applyloan1" value="/user/applyloan/1"></c:url>
						<form:form action="${applyloan1}">
							<div class="price-btn">
								<button class="outline-btn" type="submit">Apply</button>								
							</div>
						</form:form>
					</div>
				</div>
				
				
				<!-- /pricing -->

				<!-- pricing -->
				<div class="col-sm-4">
					<div class="pricing">
						<div class="price-head">
							<span class="price-title">Car Loan</span>
							<div class="price">
								<h3>9.2%<span class="duration">Interest Rate</span></h3>
							</div>
						</div>
						<ul class="price-content">
							<li>
								<p>₹8 lakhs Loan Amount</p>
							</li>
							<li>
								<p>Repay Limit 2 years</p>
							</li>
						</ul>
						<c:url var="applyloan2" value="/user/applyloan/2"></c:url>
						<form:form action="${applyloan2}">
							<div class="price-btn">
								<button class="outline-btn" type="submit">Apply</button>								
							</div>
						</form:form>
					</div>
				</div>
				<!-- /pricing -->

				<!-- pricing -->
				<div class="col-sm-4">
					<div class="pricing">
						<div class="price-head">
							<span class="price-title">Home Loan</span>
							<div class="price">
								<h3>8.3%<span class="duration">Interest Rate</span></h3>
							</div>
						</div>
						<ul class="price-content">
							<li>
								<p>₹30 lakhs Loan Amount</p>
							</li>
							<li>
								<p>Repay Limit 3 years</p>
							</li>
							
						</ul>
						<c:url var="applyloan3" value="/user/applyloan/3"></c:url>
						<form:form action="${applyloan3}">
							<div class="price-btn">
								<button class="outline-btn" type="submit">Apply</button>								
							</div>
						</form:form>
					</div>
				</div>
				<!-- /pricing -->

			</div>
			<!-- pricing -->
			<div class="col-sm-4">
					<div class="pricing">
						<div class="price-head">
							<span class="price-title">Personal Loan</span>
							<div class="price">
								<h3>9%<span class="duration">Interest Rate</span></h3>
							</div>
						</div>
						<ul class="price-content">
							<li>
								<p>₹15 lakhs Loan Amount</p>
							</li>
							<li>
								<p>Repay Limit 2 years</p>
							</li>
						</ul>
						<c:url var="applyloan4" value="/user/applyloan/4"></c:url>
						<form:form action="${applyloan4}">
							<div class="price-btn">
								<button class="outline-btn" type="submit">Apply</button>								
							</div>
						</form:form>
					</div>
				</div>
				<!-- /pricing -->

				<!-- pricing -->
				<div class="col-sm-4">
					<div class="pricing">
						<div class="price-head">
							<span class="price-title">Business Loan</span>
							<div class="price">
								<h3>13%<span class="duration">Interest Rate</span></h3>
							</div>
						</div>
						<ul class="price-content">
							<li>
								<p>₹8 lakhs Loan Amount</p>
							</li>
							<li>
								<p>Repay Limit 2 years</p>
							</li>
						</ul>
						<c:url var="applyloan5" value="/user/applyloan/5"></c:url>
						<form:form action="${applyloan5}">
							<div class="price-btn">
								<button class="outline-btn" type="submit">Apply</button>								
							</div>
						</form:form>
					</div>
				</div>
				<!-- /pricing -->

				<!-- pricing -->
				<div class="col-sm-4">
					<div class="pricing">
						<div class="price-head">
							<span class="price-title">Gold Loan</span>
							<div class="price">
								<h3>12%<span class="duration">Interest Rate</span></h3>
							</div>
						</div>
						<ul class="price-content">
							<li>
								<p>₹8 lakhs Loan Amount</p>
							</li>
							<li>
								<p>Repay Limit 2 years</p>
							</li>
						</ul>
						<c:url var="applyloan6" value="/user/applyloan/6"></c:url>
						<form:form action="${applyloan6}">
							<div class="price-btn">
								<button class="outline-btn" type="submit">Apply</button>								
							</div>
						</form:form>
					</div>
				</div>
				<!-- /pricing -->
			<!-- Row -->

		</div>
		<!-- /Container -->

	</div>
	<!-- /Pricing -->
<%@include file="footer.jsp" %>
</body>
</html>