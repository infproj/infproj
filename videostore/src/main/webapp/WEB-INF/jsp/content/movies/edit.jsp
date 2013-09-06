<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="user-edit-form">
	<c:choose>
		<c:when test="${newMovie}">
			<c:url var="submitUrl" scope="page" value="/movies/new" />
		</c:when>
		<c:otherwise>
			<c:url var="submitUrl" scope="page" value="/movies/edit/${id}" />
		</c:otherwise>		
	</c:choose>	
	<form:form action="${submitUrl}"  method="post" commandName="movie">
		<c:if test="${not newMovie}">
			<form:label path="id">ID:</form:label>
			<form:input path="id" readonly="true" />
			<br />
		</c:if>
		<form:label path="description">Description:</form:label>
		<form:input path="description" />
		<form:errors path="description" cssClass="error" />
		<br />
		<form:label path="genre">Genre:</form:label>
		<form:input path="genre" />
		<form:errors path="genre" cssClass="error" />
		<br />
		<form:label path="name">Name:</form:label>
		<form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<br />
		<form:label path="stock">Stock:</form:label>
		<form:input path="stock" />
		<form:errors path="stock" cssClass="error" />
		<br />
		<form:label path="year">Year:</form:label>
		<form:input path="year" />
		<form:errors path="year" cssClass="error" />
		<br />
		
		<input type="submit" value="Submit" />
		
	</form:form>
</div>