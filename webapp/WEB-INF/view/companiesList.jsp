<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ page import="com.andreick.manager.model.Company"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/company-form" var="addRoute" />
<c:url value="/show-company" var="editRoute" />
<c:url value="/delete-company" var="deleteRoute" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Companies</title>
</head>
<body>
  <c:import url="logoutLink.jsp" />
  User: ${authenticatedUser.login}
  <br>
  <br>
  <c:if test="${not empty newCompanyName}">
    Company ${newCompanyName} successfully registered!<br>
    <br>
    <br>
  </c:if>
  <a href="${addRoute}">add company</a>
  <br>
  <br>
  Companies list:
  <br>
  <ul>
    <c:forEach items="${companies}" var="company">
      <li>${company.name}&nbsp;-&nbsp;<fmt:formatDate
          value="${company.startDate}" pattern="dd/MM/yyyy" /> <a
        href="${editRoute}?id=${company.id}">edit</a> <a
        href="${deleteRoute}?id=${company.id}">delete</a>
      </li>
    </c:forEach>
  </ul>
</body>
</html>