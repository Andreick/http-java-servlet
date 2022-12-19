<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Company</title>
</head>
<body>
  <c:if test="${not empty companyName}">
    Company ${companyName} successfully registered!
  </c:if>
  <c:if test="${empty companyName}">
    No registered company!
  </c:if>
</body>
</html>