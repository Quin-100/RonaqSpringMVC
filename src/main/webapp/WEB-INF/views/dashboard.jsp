<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
	
	<link rel="stylesheet" href="css/all.css">	   
	<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Source+Sans+Pro:400,700,400italic,700italic' rel='stylesheet' type='text/css'>

	
	<!-- <link rel="stylesheet" href="fonts/font-awesome-4.3.0/css/font-awesome.min.css"> -->		
    <!--  --><link href="${pageContext.request.contextPath}/resources/css/all.css" rel="stylesheet" />
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
<header id="header" style="background: #212529">
			<div class="container">
				<div class="logo" style="margin: -18px 0 0 15px"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Ronaq"></a></div>
				<nav id="nav">
					<div class="opener-holder">
						<a href="#" class="nav-opener"><span></span></a>
					</div>
					<a href="#" class="btn btn-primary rounded" >Logout</a>
					<div class="nav-drop">
						<ul>
							<li class="active visible-sm visible-xs"><a href="#">Home</a></li>							
							<li><a href="#">About Us</a></li>
							<li><a href="#">Services</a></li>
							<li><a href="#">Contact Us</a></li>
						</ul>						
					</div>
				</nav>
			</div>
 </header>
 <footer>
        <div class="footer">
            <p>&copy; 2018<script>new Date().getFullYear()>2010&&document.write("-"+new Date().getFullYear());</script>
                , All rights reserved to Ronaq Co-operative bank.</p>        
                    
        </div>
 </footer> 
</body>
</html>