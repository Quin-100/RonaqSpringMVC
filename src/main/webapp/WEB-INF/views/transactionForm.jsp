<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ronaq | Transaction Form</title>
    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    
        
    <style>
		.errors {
			color: red;
			font-style: italic;
			font-weight: bold;
		}
	</style>
    
</head>
<body>
<c:url var="doTransaction" value="/user/dotransaction"></c:url>
<div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form:form  action="${doTransaction}" modelAttribute="transactions" cssClass="signup-form">
                    	<c:if test="${transactionmode == 'samebranch'}">
                    		<h2 class="form-title">Within Same Branch</h2>
                    	</c:if>
                    	
                    	<c:if test="${transactionmode == 'differentbranch'}">
                    		<h2 class="form-title">Within Different Branch</h2>
                    	</c:if>                   	
                        
                        <div class="form-group">
                                <form:select path="benname" cssClass="form-input" items="${listBeneficiary}">                              
						        </form:select>                                	
                                <form:errors path="benname" cssClass="errors"></form:errors>   
                        </div>
                        
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="form-group">
                                    <form:input path="amount" cssClass="form-input" placeholder="Enter Amount"/>
                                    <form:errors path="amount" cssClass="errors"></form:errors>
                                </div>
                            </div>
                        </div>   
                        
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="form-group">
                                    <form:textarea path="extranote" cssClass="form-input" placeholder="Extra Note."/>
                                    <form:errors path="extranote" cssClass="errors"></form:errors>
                                </div>
                            </div>
                        </div>               
                          
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Send"/>
                        </div>
                    </form:form>                    
                </div>
            </div>
        </section>
    </div>
</body>
</html>