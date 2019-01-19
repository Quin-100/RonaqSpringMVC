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
    <title>Ronaq | Forgot Password Form</title>

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
<c:url var="forgotPasswordAction" value="/user/forgotpassword" ></c:url>
    <div class="main">
        <section class="signup">
            <!-- <img src="images/image2.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                	<form:form action="${forgotPasswordAction}" modelAttribute="user" cssClass="signup-form" id="signup-form">
                		<h2 class="form-title">Create account</h2>   
                       
                        <div class="row">
                        	<div class="col-md-12">
                        		<div class="form-group">
                                	<form:input path="email" cssClass="form-input" placeholder="Enter your email" id="email"/>
                                    <form:errors path="email" cssClass="errors"></form:errors> 
                                </div>                        	
                        	</div>
                        </div>                         
                        <div class="row">
                        	<div class="col-md-12">
                        		<div class="form-group">                        		
	                                <form:select path="securityQuestion" cssClass="form-input">  
	                                	 <form:option selected="selected" value="1">What was your childhood nickname?</form:option>
							                <form:option value="2">What is the name of your favorite childhood friend?</form:option>
							                <form:option value="3">What was the second best birthday present you ever got?</form:option>
							                <form:option value="4">In what city or town did your mother and father meet?</form:option>
							                <form:option value="5">What was your favorite sport in high school?</form:option>
							                <form:option value="6">Who is your childhood sports hero?</form:option>
							                <form:option value="7">What was the name of the company where you had your first job?</form:option>
							                <form:option value="8">What was the make and model of your first car?</form:option>
							                <form:option value="9">What school did you attend for sixth grade?</form:option>                     
							        </form:select>                                	
	                                <form:errors path="securityQuestion" cssClass="errors"></form:errors>   
                        		</div>
                        	</div>     
                        </div>
                        <div class="row">
                        	<div class="col-md-12">                        		
                        		<form:input path="securityAnswer" cssClass="form-input" placeholder="Enter your answer" />
                                <form:errors path="securityAnswer" cssClass="errors"></form:errors> 
                        	</div>     
                        </div>
                        <br><br>
                        
                        <div class="form-group">
                        	<input type="submit" name="submit" id="submit" class="form-submit" value="<spring:message text="Next"/>" />
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