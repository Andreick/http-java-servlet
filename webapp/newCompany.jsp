<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%
//scriplet
String companyName = (String) request.getAttribute("companyName");
System.out.println(companyName);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Company Response</title>
</head>
<body>
  Company
  <%=companyName%>
  successfully registered!
</body>
</html>