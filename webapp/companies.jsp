<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@page import="com.andreick.manager.data.Company"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Companies</title>
</head>
<body>
  Companies list:
  <br />
  <ul>
    <%
    List<Company> companies = (List<Company>) request.getAttribute("companies");
    for (Company company : companies) {
    %>
    <li><%=company.getName()%></li>
    <%
    }
    %>
  </ul>
</body>
</html>