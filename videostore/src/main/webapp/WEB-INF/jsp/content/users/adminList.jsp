<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="user-list">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>birthday</th>
				<th>email</th>
				<th>lastname</th>
				<th>name</th>
				<th>edit</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${admins}" var="admin" varStatus="status">
				<tr
					class="${(status.count % 2 == 0) ? 'even' : 'odd'}${status.last ? ' last' : ''}">
					<td>${admin.id}</td>
					<td>${admin.birthday}</td>
					<td>${admin.email}</td>
					<td>${admin.lastname}</td>
					<td>${admin.name}</td>
					<td><a href='<c:url value="/admin/edit/${admin.id}"/>'>edit</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>