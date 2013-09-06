<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="user-list">
	<form action="/videostore/home" method="post">
		Movie name: <input type="text" name="name"><br> 
		<input	type="submit" value="Submit">
	</form>
	<table>
		<thead>
			<tr>

				<th><fmt:message key="page.home.id" /></th>
				<th><fmt:message key="page.home.name" /></th>
				<th><fmt:message key="page.home.genre" /></th>
				<th><fmt:message key="page.home.year" /></th>
				<th><fmt:message key="page.home.descriptio" /></th>
				<th><fmt:message key="page.home.stock" /></th>
				

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="movie" varStatus="status">
				<tr
					class="${(status.count % 2 == 0) ? 'even' : 'odd'}${status.last ? ' last' : ''}">
					<td>${movie.id}</td>
					<td>${movie.name}</td>
					<td>${movie.genre}</td>
					<td>${movie.year}</td>
					<td>${movie.description}</td>
					<td>${movie.stock}</td>
					<td><a href='<c:url value="/movies/reservate/${movie.id}"/>'><fmt:message key="page.home.reserve"></fmt:message></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>