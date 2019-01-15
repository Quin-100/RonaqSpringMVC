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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ronaq | Sign-in Form</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->    
    <!--  --><link href="${pageContext.request.contextPath}/resources/css/register.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    

    
</head>
<body>
	<c:url var="loginAction" value="/user/login" ></c:url>
    <div class="main">
        <section class="signup">
            <!-- <img src="images/image2.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                	<form:form action="${loginAction}" modelAttribute="login" id="signup-form" cssClass="signup-form">
                		<h2 class="form-title">Login</h2>
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="form-group">
                                	<form:input path="username" cssClass="form-input" placeholder="Username" id="name"/>
									<form:errors path="username" cssClass="errors"></form:errors>                                   
                                </div>
                            </div>
                        </div>
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="form-group">
                                	<form:input path="password" cssClass="form-input" placeholder="Password" id="password"/>
                                	<span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                                    <form:errors path="password" cssClass="errors"></form:errors>                                   
                                    
                                </div>
                            </div>                               
                        </div>  
                        <div class="row"></div>
                            <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Login"/>
                            </div>
                        </div>
                	</form:form>                    
                    <p class="loginhere">
                        Forgot password ? <a href="forgotpassword" class="loginhere-link">Forgot password</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->    
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>