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
    <title>Ronaq | Sign-up Form</title>

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
    
    <script type="text/javascript">
	    window.onload = function () {
	        var pass = document.getElementById("password");
	        var re_password = document.getElementById("re_password");
	       	password.onchange = chkPassword;
	       	re_password.onkeyup = chkPassword;
	        function chkPassword() {
	        	re_password.setCustomValidity("");
	            if (password.value != re_password.value) {
	            	re_password.setCustomValidity("Enter correct password.");
	            }
	        }
	    }
    </script>

    <script>
        $(document).ready(function(){
            $( "#dob" ).datepicker({
                dateFormat : 'mm/dd/yy',
                changeMonth : true,
                changeYear : true,
                yearRange: '-100y:c+nn',
                maxDate: '-1d'
            });
        });
     </script>
     
     <style>
		.errors {
			color: red;
			font-style: italic;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<c:url var="addAction" value="/user/add" ></c:url>
    <div class="main">

        <section class="signup">
            <!-- <img src="images/image2.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                	<form:form action="${addAction}" modelAttribute="user" cssClass="signup-form" id="signup-form">
                		<h2 class="form-title">Create account</h2>
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:input path="name" cssClass="form-input" placeholder="Your Name" id="name" pattern="[a-z A-Z]*"/>
									<form:errors path="name" cssClass="errors"></form:errors>
<!--                                     <input type="text" class="form-input" name="name" id="name" placeholder="Your Name"/> -->
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:input path="pan" cssClass="form-input" placeholder="Pan card no." id="pan" maxlength="10"/>
                                    <form:errors path="pan" cssClass="errors"></form:errors>
                                </div>
                            </div>
                        </div> 
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:input path="aadhar" cssClass="form-input" placeholder="Aadhar no." id="aadhar" maxlength="12"/>
                                    <form:errors path="aadhar" cssClass="errors"></form:errors>                                   
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group"> 
                                	<form:input type="date" path="dob" class="form-input" id="dob"/>
                                    <form:errors path="dob" cssClass="errors"></form:errors>                                    
                                </div>                                
                            </div>
                        </div>  
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:input path="address" cssClass="form-input" placeholder="Address Details" id="address"/>
                                    <form:errors path="address" cssClass="errors"></form:errors>                                                
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">   
                                	<form:select path="acctype" cssClass="form-input">						                
						                <form:option selected="selected" value="savings">Savings</form:option>
						                <form:option value="current">Current</form:option>
						            </form:select>    
                                    <form:errors path="acctype" cssClass="errors"></form:errors> 
                                </div>
                            </div>                           
                        </div> 
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:select path="state" cssClass="form-input">						               
						                <form:option selected="selected"  value="maharashtra">Maharashtra</form:option>
						                <form:option value="kerala">Kerala</form:option>
						                <form:option value="gujarat">Gujarat</form:option>
						                <form:option value="punjab">Punjab</form:option>
						            </form:select>                                	
                                    <form:errors path="state" cssClass="errors"></form:errors>             
                                    
                                </div>
                            </div>
                             <div class="col-md-6">
                                <div class="form-group">
                                	<form:select path="branch" cssClass="form-input">						                
						                <form:option selected="selected" value="Ahmedabad">Ahmedabad-RNQAH000504</form:option>
						                <form:option value="Pune">Pune-RNQPU000506</form:option>
						                <form:option value="Nagpur">Nagpur-RNQNG000508</form:option>
						                <form:option value="Vadodra">Vadodra-RNQVD000502</form:option>
						                <form:option value="Amritsar">Amritsar-RNQAM000510</form:option>
						                <form:option value="Ludhiana">Ludhiana-RNQLU000512</form:option>
						                <form:option value="Chandigarh">Chandigarh-RNQCH000514</form:option>
						                <form:option value="Kochi">Kochi-RNQKO000516</form:option>
						                <form:option value="Thiruvananthapuram">Thiruvananthapuram-RNQTH000518</form:option>
						            </form:select>   
                                    <form:errors path="branch" cssClass="errors"></form:errors>                                             
                                   
                                </div>
                            </div>
                        </div> 
                        <div class="row">
                        	<div class="col-md-12">
                        		<div class="form-group">
                                	<form:input path="email" cssClass="form-input" placeholder="Enter your email" id="email"/>
                                    <form:errors path="email" cssClass="errors"></form:errors> 
                                </div>                        	
                        	</div>
                        </div>
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:input path="password" cssClass="form-input" placeholder="Password" id="password"/>
                                    <form:errors path="password" cssClass="errors"></form:errors>   
                                    <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                	<form:input path="repassword" cssClass="form-input" placeholder="Repeat your password" id="re_password"/>
                                    <form:errors path="repassword" cssClass="errors"></form:errors> 
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
                        
                        
                        
                        <!-- <div class="row">
                        	<p>Upload your photo</p><input type="file" name="fileUpload" size="50" />
                        	<button href="doUpload">upload</button>
                        </div>  -->
                       
                        <div class="form-group">
                        	<input type="submit" name="submit" id="submit" class="form-submit" value="<spring:message text="Sign up"/>" />
                        </div>
                	</form:form>                    
                    <p class="loginhere">
                        Already have an account ? <a href="login" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->    
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>