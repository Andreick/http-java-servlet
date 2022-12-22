<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/edit-company" var="editRoute" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Company Form</title>
</head>
<body>
  <c:import url="logoutLink.jsp" />
  <form action="${editRoute}" method="POST">
    Name: <input type="text" name="name" value="${company.name}">
    Start date: <input type="text" name="startDate"
      value="<fmt:formatDate value="${company.startDate}" pattern="dd/MM/yyyy" />">
    <input type="hidden" name="id" value="${company.id}"> <input
      type="submit">
  </form>
</body>
</html>