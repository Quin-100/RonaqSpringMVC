<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Ronaq | Transactions</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!--// Meta tag Keywords -->
<!-- css files -->

<link href="${pageContext.request.contextPath}/resources/css/transactions/bootstrapa.css" rel="stylesheet" type="text/css" media="all" /> <!-- Bootstrap-Core-CSS -->
<link href="${pageContext.request.contextPath}/resources/css/transactions/stylea.css" rel="stylesheet" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.3.0/css/font-awesome.min.css"> <!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->


<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Source+Sans+Pro:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!-- //online-fonts -->
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
<%@include file="header.jsp" %>
<div class="services" id="services" style="margin-top: 60px;">
		<div class="container">
			<h3 class="w3l-title"><span></span>Transactions</h3>
			<div class="col-md-4 services-grids-1">
				
			</div>
			<div class="col-md-4 services-grids">
				<div class="wthree-services-grid" href="samebranch">
					
					<div class="wthree-services-icon">
						<i class="fa fa-money" aria-hidden="true"></i>
					</div>
					<div class="wthree-services-info">
						<h5><a href="samebranch"></a>Same Branch </h5>
						<p>Experience the all new Inter Banking</p>
					</div>
				</div>
				<div class="wthree-services-grid w3l-agile">
					<div class="wthree-services-icon">
						<i class="fa fa-user" aria-hidden="true"></i>
					</div>
					<div class="wthree-services-info">
						<h5><a href="differentbranch"></a>Different Branch</h5>
						<p>Intra Banking made easier </p>
					</div>
				</div>				
				<div class="wthree-services-grid">					
					<div class="wthree-services-icon" >
						<i class="fa fa-car" aria-hidden="true" ></i>
					</div>
					<div class="wthree-services-info">
						<h5><a href="beneficiary">Add Benificiary</a></h5>
						<p>Add your Beneficiary details here </p>
					</div>
				</div>
			</div>

			<div class="clearfix"> </div>
		</div>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>