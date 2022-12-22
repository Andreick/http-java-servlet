<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/new-company" var="newRoute" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Company Form</title>
</head>
<body>
  <c:import url="logoutLink.jsp" />
  <form action="${newRoute}" method="POST">
    Name: <input type="text" name="name"> Start date: <input
      type="text" name="startDate"> <input type="submit">
  </form>
</body>
</html>