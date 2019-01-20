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
<meta charset="ISO-8859-1">
<title>Ronaq | Add Beneficiary</title>
	<!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->    
    <!--  --><link href="${pageContext.request.contextPath}/resources/css/register.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
		.errors {
			color: red;
			font-style: italic;
			font-weight: bold;
		}
	</style>
</head>
<body>
<c:url var="addAction" value="/user/addBeneficiary" ></c:url>
    <div class="main">

        <section class="signup">
            <!-- <img src="images/image2.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                	<form:form action="${addAction}" modelAttribute="beneficiary" cssClass="signup-form" id="signup-form">
                		<h2 class="form-title">Add Beneficiary</h2>
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="form-group">
                                	<form:input path="name" cssClass="form-input" placeholder="Payee Name" id="name" pattern="[a-z A-Z]*"/>
									<form:errors path="name" cssClass="errors"></form:errors>
<!--                                     <input type="text" class="form-input" name="name" id="name" placeholder="Your Name"/> -->
                                </div>
                            </div>                            
                        </div> 
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="form-group">
                                	<form:input path="accountno" cssClass="form-input" placeholder="Payee acoount no." id="pan" maxlength="12"/>
                                    <form:errors path="accountno" cssClass="errors"></form:errors>
                                </div>
                            </div>                            
                        </div>  
                        <div class="row"> 
                            <div class="col-md-12">
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
                             <div class="col-md-12">
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
                        <div class="form-group">
                        	<input type="submit" name="submit" id="submit" class="form-submit" value="<spring:message text="Add Beneficiary"/>" />
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