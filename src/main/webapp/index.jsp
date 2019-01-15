<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Ronaq Co-oprative Bank</title>	
	<link rel="icon" type="image/png" href="favicons/favicon-16x16.png" sizes="16x16">


	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

	
	<!-- <link rel="stylesheet" href="fonts/font-awesome-4.3.0/css/font-awesome.min.css"> -->		
    <!--  --><link href="${pageContext.request.contextPath}/resources/css/all.css" rel="stylesheet" />
	<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Source+Sans+Pro:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="wrapper">
		<header id="header">
			<div class="container">
				<div class="logo"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Ronaq"></a></div>
				<nav id="nav">
					<div class="opener-holder">
						<a href="#" class="nav-opener"><span></span></a>
					</div>
					<a href="login" class="btn btn-primary rounded" >Login</a>
					<div class="nav-drop">
						<ul>
							<li class="active visible-sm visible-xs"><a href="#">Home</a></li>							
							<li><a href="#">About Us</a></li>
							<li><a href="#">Services</a></li>
							<li><a href="aboutus">About Us</a></li>
						</ul>						
					</div>
				</nav>
			</div>
		</header>
	<section class="visual">
		<div class="container">
			<div class="text-block">
				<div class="heading-holder">
					<h1>Your Trust is our motto</h1>
				</div>
				<p class="tagline">A happier & trustfull banking is waiting for you!</p>				
			</div>
		</div>
		<img src="${pageContext.request.contextPath}/resources/images/train.jpg" alt="" class="bg-stretch">
	</section>
	<section class="main">
		<div class="container">
			<div id="cta">
				<a href="register" class="btn btn-primary rounded">Start Banking Now</a>
				<p>Every day is a challenge, change a way of banking.</p>
			</div>
			<!-- <div class="row">
				<div class="text-box col-md-offset-1 col-md-12">
					<h2>About the Club</h2>
					<p>An athlete cannot run with money in his pockets. He must run with hope in his heart and dreams in his head.</p>
				</div>
			</div> -->
		</div>
	</section>
	<section class="area">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<ul class="visual-list">
						<li>
							<div class="img-holder">
								<img src="${pageContext.request.contextPath}/resources/images/fund1.png" width="110" alt="">
							</div>
							<div class="text-holder">
								<h3>Easy Money Transfer</h3>
								<p>Aenean cursus imperdiet nisl id fermentum. Aliquam pharetra dui laoreet vulputate dignissim. Sed id metus id quam auctor molestie eget ut augue. </p>
							</div>
						</li>						
						<li>
							<div class="img-holder">
								<img src="${pageContext.request.contextPath}/resources/images/graph-02.svg" height="84" alt="">
							</div>
							<div class="text-holder">
								<h3>Apply For Loan</h3>
								<p>Maecenas eu dictum felis, a dignissim nibh. Mauris rhoncus felis odio, ut volutpat massa placerat ac. Curabitur dapibus iaculis mi gravida luctus. Aliquam erat volutpat. </p>
							</div>
						</li>
						<li>
							<div class="img-holder">
								<img src="${pageContext.request.contextPath}/resources/images/graph-01.svg" height="71" alt="">
							</div>
							<div class="text-holder">
								<h3>Get Your CIBIL</h3>
								<p>Maecenas eu dictum felis, a dignissim nibh. Mauris rhoncus felis odio, ut volutpat massa placerat ac. Curabitur dapibus iaculis mi gravida luctus. Aliquam erat volutpat. </p>
							</div>
						</li>
					</ul>
				</div>
				<div class="col-md-7">
					<div class="slide-holder">
						<div class="img-slide scroll-trigger"><img src="${pageContext.request.contextPath}/resources/images/village.jpg" height="425" width="684" alt=""></div>
					</div>
				</div>
			</div>
		</div>
	</section>		
	
	<footer id="footer">
		<div class="container">
			<div class="footer-holder">
				<div class="row  text-center">
					<div class="col-md-12">
						<a href="#"><img src="${pageContext.request.contextPath}/resources/images/logo_footer.png" alt="Ronaq"></a>
					</div>
					  
				</div>
                <div class="row">
                	<div id="cta" class="cta-footer col-md-12">
                        <a href="javascript:" class="btn btn-primary rounded">More About Us</a>
                        <p>Get a handfull experirnce in banking with us.</p>
                    </div>
                </div>
                <div class="row">
                	<div class="col-md-6">                    	
                    </div>
                    
                    <div class="col-md-6 text-right">
                    	<ul class="social">
                        	
							<li><a href="javascript:"><i class="fa fa-facebook"></i></a></li>
							<li><a href="javascript:"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="javascript:"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="javascript:"><i class="fa fa-pinterest"></i></a></li>
                        </ul>
                    </div>
                </div>
			</div>
		</div>
	</footer>
</div>
<!-- <script src="js/jquery-1.11.2.min.js"></script> -->
<!-- <script src="js/bootstrap.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.main.js"></script>
</body>
</html>