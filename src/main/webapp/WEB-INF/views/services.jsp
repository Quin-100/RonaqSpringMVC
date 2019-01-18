<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Ronaq | Services</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Invest project">
<meta name="viewport" content="width=device-width, initial-scale=1"><script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/services/services.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/services/services_responsive.css">


<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Source+Sans+Pro:400,700,400italic,700italic' rel='stylesheet' type='text/css'>

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
<div class="super_container">

	<!-- Points -->

	<div class="points">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container">
						<div class="section_subtitle">take a look at</div>
						<div class="section_title">Our Services</div>
					</div>
				</div>
			</div>			
		</div>
	</div>

	<!-- Services -->

	<div class="services">
		<div class="services_background parallax-window" data-parallax="scroll" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col d-flex flex-row flex-wrap align-items-start justify-content-start">

					<!-- Service -->
					<div class="service">
						<div class="service_icon"><img src="${pageContext.request.contextPath}/resources/images/services/cibil.png" class="svg" alt=""></div>
						<div class="service_title">Calculate Cibil</div>
						<div class="service_text">
							<p>Credit score determines your loan eligibility.Kindly check your score here before applying for loan.</p>
						</div>
						<div class="service_link"><a href="#">Read More</a></div>
					</div>

					<!-- Service -->
					<div class="service">
						<div class="service_icon"><img src="${pageContext.request.contextPath}/resources/images/services/loan.png" class="svg" alt=""></div>
						<div class="service_title">Apply for Loan</div>
						<div class="service_text">
							<p>RONAQ provides loans with lowest interest rates, instant approval, minimum documentation.</p>
						</div>
						<div class="service_link"><a href="loans">Read More</a></div>
					</div>

					<!-- Service -->
					<div class="service">
						<div class="service_icon"><img src="${pageContext.request.contextPath}/resources/images/services/moneytransfer.png" class="svg" alt=""></div>
						<div class="service_title">Money Transfer</div>
						<div class="service_text">
							<p>With RONAQ get the most for your money. Free, fair and fast money transfers. </p>
						</div>
						<div class="service_link"><a href="transactions">Read More</a></div>
					</div>

					<!-- Service -->
					<div class="service">
						<div class="service_icon"><img src="${pageContext.request.contextPath}/resources/images/services/download.png" class="svg" alt=""></div>
						<div class="service_title">Locate Branch</div>
						<div class="service_text">
							<p>Find your nearest RONAQ bank branch with our branch locator.</p>
						</div>
						<div class="service_link"><a href="#">Read More</a></div>
					</div>
				</div>
			</div>
		</div>
	</div>				
</div>
<%@include file="footer.jsp" %>
</body>
</html>