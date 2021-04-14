<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language</title>
</head>
<body>
<h1>All Languages</h1>
		<table>
        <c:forEach items="${languages}" var="language">
        <tr>
        	<th>name</th>
        	<th>Creator</th>
        	<th>Current Version</th>
        	<th>Actions</th>
        </tr>
        <tr>
        	<td><c:out value="${language.name}"/></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td> <a href="/languages/${language.id}/edit">Edit</a> <a href="/languages/${language.id}">Delete</a></td>
        </tr>
     
        </c:forEach>
		</table>

<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Current Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>