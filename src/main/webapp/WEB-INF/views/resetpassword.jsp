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
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ronaq | Reset Password Form</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->    
    <link href="${pageContext.request.contextPath}/resources/css/register.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!-- Main js -->
    <link href="${pageContext.request.contextPath}/resources/js/formValidation.js" rel="stylesheet" />
    
    <!-- jquery core js -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    
    <style>
		.errors {
			color: red;
			font-style: italic;
			font-weight: bold;
		}
	</style>
</head>
<body>
<c:url var="resetPasswordAction" value="/user/resetpassword" ></c:url>
    <div class="main">
        <section class="signup">
            <!-- <img src="images/image2.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                	<form:form action="${resetPasswordAction}" modelAttribute="user" cssClass="signup-form" id="signup-form">
                		<h2 class="form-title">Reset Password</h2>   
                       
                        <div class="row">
                        	<div class="col-md-12">
                        		<div class="form-group">
                                	<form:input path="password" cssClass="form-input" placeholder="Enter your password" id="password"/>
                                    <form:errors path="password" cssClass="errors"></form:errors> 
                                </div>                        	
                        	</div>
                        </div>                         
                        <div class="row">
                        	<div class="col-md-12">
                        		<div class="form-group">                        		
	                               <form:input path="repassword" cssClass="form-input" placeholder="Repeat your password" id="re_password"/>
                                   <form:errors path="repassword" cssClass="errors"></form:errors>    
                        		</div>
                        	</div>     
                        </div>                       
                        <br><br>
                        
                        <div class="form-group">
                        	<input type="submit" name="submit" id="submit" class="form-submit" value="<spring:message text="Reset Password"/>" />
                        </div>
                	</form:form> 
                </div>
            </div>
        </section>

    </div>
    
    <!-- JS -->    
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>