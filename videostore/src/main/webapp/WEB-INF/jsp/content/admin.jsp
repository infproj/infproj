<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="user-list">
	<form action="/videostore/admin/findMov" method="post">
		Movie name: <input type="text" name="name"><br> 
		<input	type="submit" value="Submit">
	</form>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Genre</th>
				<th>Description</th>
				<th>Year</th>
				<th>Stock</th>
				<th>Rent</th>
				<th>Update</th>
				<td>Delete</td>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="movie" varStatus="status">
				<tr
					class="${(status.count % 2 == 0) ? 'even' : 'odd'}${status.last ? ' last' : ''}">
					<td>${movie.id}</td>
					<td>${movie.name}</td>
					<td>${movie.genre}</td>
					<td>${movie.description}</td>
					<td>${movie.year}</td>
					<td>${movie.stock}</td>
					<td><a href='<c:url value="/movies/rent/${movie.id}"/>'>rent</a></td>
					<td><a href='<c:url value="/movies/edit/${movie.id}"/>'>update</a></td>
					<td><a href='<c:url value="/movies/delete/${movie.id}"/>'>delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>