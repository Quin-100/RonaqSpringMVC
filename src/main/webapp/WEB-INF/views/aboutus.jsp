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
<title>About Us</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">


<!-- Default-JavaScript-File -->	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	
	
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<!-- default css files -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/aboutus/bootstrap5.css" type="text/css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/aboutus/style5.css" type="text/css" media="all">
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
<div class="bannerbottom" id="about">
	<div class="contain">
		<img src="${pageContext.request.contextPath}/resources/images/aboutus/download1.jpg" alt=" " class="img-responsive">
		<div class="centered">We're just the bank you need </div>
	</div>
	<div class="container">
		<div class="servicetext">
			
			<h3>Know Us</h3>
			<p>	RONAQ strives to serve customers by providing them high street and internet banking,current and 
					savings accounts,mortages and loans. We pride ourselves on our customer services and customer 
					satisfaction levels, and we are always looking to put our customers at the heart of what we do.
					Towering above its coompetitors and growing soundly since it is established. 
					Today, RONAQ co-operative is spread across four states-Maharashtra, Gujarat, Kerala and Punjab.
				</p>			
				
		</div>
	</div>
</div>
<!-- banner-bottom -->
					
<!-- choice -->
<div class="choice">
	<div class="col-md-6 choice-left">
	<h3>Why RONAQ?</h3>
	<p><span class="glyphicon glyphicon-check" aria-hidden="true"></span> We provide trusted Services</p>
	<p><span class="glyphicon glyphicon-compressed" aria-hidden="true"></span> We go above and beyond to help</p>
	<p><span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span> Client satisfaction is our ultimate goal</p>
	<p><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span> We always strive for innovation</p>
	</div>
	<div class="col-md-6 choice-right">
		<img src="${pageContext.request.contextPath}/resources/images/aboutus/money.jpg" alt="" />
	</div>
	<div class="clearfix"></div>
</div>
<!-- //choice -->

<!--testimonials-->
<div id="testimonials" class="testimonials">
	<div class="container">
		<h3 class="heading-agileinfo">Our Team</h3>
		<div class="flex-slider">
			<ul id="flexiselDemo1">			
				<li>
					<div class="laptop">
						<div class="col-md-4 team-left">
							<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/aboutus/test1.png" alt=" " />
						</div>
						<div class="col-md-8 team-right">
							<p>The challenge for banks isn't becoming "digital"-it's providing value that is perceived to be in line with the cost-or bbetter yet, providing value that consumers are comfortable paying for.</p>
							<div class="name-w3ls">
								<h5>Anuradha Patil</h5>
								<span>--Chairman</span>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</li>
				<li>
					<div class="laptop">
						<div class="col-md-4 team-left">
							<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/aboutus/test2.png" alt=" " />
						</div>
						<div class="col-md-8 team-right">
							<p>The challenge for banks isn't becoming "digital"-it's providing value that is perceived to be in line with the cost-or better yet, providing value that consumers are comfortable paying for.
							</p>
							<div class="name-w3ls">
								<h5>Srikanth Shetty</h5>
								<span>--Vice Chairman</span>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</li>				
			</ul>
			
		</div>

	</div>
</div>
<!--//testimonials-->

<!--footer-->
<div class="contact-agile" id="contact">
			<div class="container">
					<div class="container">
							<div class="col-md-6">
									<div class="form-style-6">
											<h1>Give your Feedback here</h1>
											<c:url var="feedbackAction" value="/user/feedback"></c:url>
											<form:form action="${feedbackAction}" modelAttribute="feedbackform">
											<form:input path="name" name="name" placeholder="Your Name" required="Field is required"/>
											<form:errors path="name" cssClass="errors"></form:errors>
											
											<form:input path="email" name="email" placeholder="Email Address" required="Field is required"/>
											<form:errors path="email" cssClass="errors"></form:errors>
											
											<form:input path="phone" name="phone" placeholder="Phone No" maxlength="10" required="Field is required"/>
											<form:errors path="phone" cssClass="errors"></form:errors>											
											
											<form:textarea path="message" name="message" placeholder="Enter your Feedback here" required="Field is required"/>
											<form:errors path="message" cssClass="errors"></form:errors>	
											
											<input type="submit" value="Submit" />
											</form:form>
									</div>
							</div>
							<div class="col-md-6 contact-left">
								<h4>Our Address</h4>
								<p>Madhushree Own building Sector 17, Near Axis Bank, Liberty Housing Society, Sector 17,</p>
								<p> Vashi, Navi Mumbai, Maharashtra 400703</p>
								<div class="number">
									<h4>Phone</h4>
									<p><a href="javascript:void(0)">022 2789 0192</a></p>
								</div>
								<h4>Email</h4>
								<p><a href="javascript:void(0)">ronaq.support@abc.com</a></p>
							</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div id="map-container-google-9" class="z-depth-1-half map-container-5" style="height: 300px">
				
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3770.8769354777905!2d72.99819051392976!3d19.06914765714548!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c1493ba92fff%3A0xe61d64adf206b839!2sThe+Saraswat+Co-operative+Bank+Ltd!5e0!3m2!1sen!2sin!4v1547561877150"
				 width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
		    </div>
<!--/footer -->
<%@include file="footer.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/aboutus/numscroller-1.05.js"></script><!-- numscroller js file -->


<script type="text/javascript">
	$(window).load(function () {
		$("#flexiselDemo1").flexisel({
			visibleItems: 2,
			animationSpeed: 1000,
			autoPlay: true,
			autoPlaySpeed: 3000,
			pauseOnHover: true,
			enableResponsiveBreakpoints: true,
			responsiveBreakpoints: {
				portrait: {
					changePoint: 480,
					visibleItems: 1
				},
				landscape: {
					changePoint: 640,
					visibleItems: 1
				},
				tablet: {
					changePoint: 991,
					visibleItems: 1
				}
			}
		});

	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/aboutus/jquery.flexisel5.js"></script>
<!--//flexiselDemo1 -->

</body>
</html>