<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/login" var="loginRoute" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
  <form action="${loginRoute}" method="POST">
    Login: <input type="text" name="login"> Password: <input
      type="password" name="password"> <input type="submit">
  </form>
</body>
</html>