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
    <title>Ronaq | Loan Eligibility Form</title>
    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">  
</head>
<body>
<c:if test="${cibil > 750}">
	<c:url var="applyloan" value="/user/loanapplication"></c:url>
</c:if>
<c:if test="${cibil < 750}">
	<c:url var="applyloan" value="/user/loans"></c:url>
</c:if>
<div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form:form  action="${applyloan}" cssClass="signup-form">
                    	
                    	<h2 class="form-title">Loan Eligibility Form</h2>   
                        
                        <div class="row">
                        <table class="table table-striped">								
							<tbody>
								<c:set var="cibil" value="${cibil}"></c:set>
								<c:if test="${cibil > 750}">									
									<tr>
										<c:set var="retamt" value="${retamt}"></c:set>
										<td>You have to pay total return amount including interest rate :${retamt}</td>
									</tr>
									<tr>										
										<td>We had calculated cibil for you :</td>
										<td>${cibil}</td>
									</tr>
								</c:if>
								<c:if test="${cibil < 750}">									
									<tr>
										<td>Your cibil score is too low :${cibil}</td>
									</tr>
									<tr>
										<td>you are not eligible for loan</td>
									</tr>
								</c:if>
																									
							</tbody>
						</table>
                         </div>                      
                         
                        <br><br>
                        <div class="row">                        
                            <div class="col-md-6">
                            	<c:if test="${cibil > 750}">
                            		<input type="submit" name="calcreturnamount" id="calc" class="form-submit" value="Apply"/>
                            	</c:if>
	                        	<c:if test="${cibil < 750}">
	                        		<input type="submit" name="calcreturnamount" id="calc" class="form-submit" value="Ok"/>
	                        	</c:if>
	                        	<br><br>
	                        </div>	                        
                        </div>
                    </form:form>                    
                </div>
            </div>
        </section>
 </div>
</body>
</html>