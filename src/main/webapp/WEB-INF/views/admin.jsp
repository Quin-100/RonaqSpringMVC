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
<title>Add Loan type</title>
</head>
<body>
<h1>Add Loan Type</h1>
<c:url var="addLoanType" value="/add/loan"></c:url>
<form:form action="${addLoanType}" modelAttribute="loans">
Loan Type :<form:input path="loantype" />
Interest Rate : <form:input path="loanrate" />
Amount limit : <form:input path="amountlimit" />
Repay limit : <form:input path="repaylimit" />

<input type="submit" value="Add Loan"/>
</form:form>				
					
</body>
</html>