<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="user-edit-form">
	<c:choose>
		<c:when test="${newAdmin}">
			<c:url var="submitUrl" scope="page" value="/admin/new" />
		</c:when>
		<c:otherwise>
			<c:url var="submitUrl" scope="page" value="/admin/edit/${id}" />
		</c:otherwise>		
	</c:choose>	
	<form:form action="${submitUrl}"  method="post" commandName="admin">
		<c:if test="${not newAdmin}">
			<form:label path="id">ID:</form:label>
			<form:input path="id" readonly="true" />
			<br />
		</c:if>
		<form:label path="birthday">Birthday:</form:label>
		<form:input path="birthday" />
		<form:errors path="birthday" cssClass="error" />
		<br />
		<form:label path="email">E-mail:</form:label>
		<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		<form:label path="lastname">Last Name:</form:label>
		<form:input path="lastname" />
		<form:errors path="lastname" cssClass="error" />
		<br />
		<form:label path="name">Name:</form:label>
		<form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<br />
		<form:label path="password">Password:</form:label>
		<form:input path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		<form:label path="username">Username:</form:label>
		<form:input path="username" />
		<form:errors path="username" cssClass="error" />
		<br />
		
		<input type="submit" value="Submit" />
		
	</form:form>
</div>