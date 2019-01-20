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
    <title>Ronaq | Cibil Calculation Form</title>
    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">  
</head>
<body>

<c:url var="okcibil" value="/user/services"></c:url>

<div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form:form  action="${okcibil}" cssClass="signup-form">
                    	
                    	<h2 class="form-title">Your Cibil</h2>   
                        
                        <div class="row">
                        <table class="table table-striped">								
							<tbody style="float: right;">
								<c:set var="cibil" value="${cibil}"></c:set>
								<c:if test="${cibil > 800}">
									<tr>
										<img src="${pageContext.request.contextPath}/resources/images/love.svg" style="width: 120px;margin-left:80px" alt="logo" />
									</tr>
									<tr>										
										<td>We had calculated cibil for you :</td>
										<td>${cibil}</td>
									</tr>
								</c:if>
								<c:if test="${cibil > 600 && cibil < 800}">
									<tr>
										<img src="${pageContext.request.contextPath}/resources/images/smile.svg" style="width: 120px;" alt="logo" />
									</tr>
									<tr>										
										<td>We had calculated cibil for you :</td>
										<td>${cibil}</td>
									</tr>
								</c:if>
								<c:if test="${cibil < 600}">			
									<tr>
										<img src="${pageContext.request.contextPath}/resources/images/sad.svg" style="width: 120px;" alt="logo" />
									</tr>						
									<tr>
										<td>Your cibil score is too low :${cibil}</td>
										<td>${cibil}</td>
									</tr>									
								</c:if>
																									
							</tbody>
						</table>
                         </div>                      
                         
                        <br><br>
                        <div class="row">                        
                            <div class="col-md-6"> 
	                        		<input type="submit" name="calcreturnamount" id="calc" class="form-submit" value="Ok"/>
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