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
				<th>Movie</th>
				<th>User</th>
				<th>Cancel Reservation</th>
				

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reservations}" var="reservation" varStatus="status">
				<tr
					class="${(status.count % 2 == 0) ? 'even' : 'odd'}${status.last ? ' last' : ''}">
					<td>${reservation.id}</td>
					<td>${reservation.movie.name}</td>
					<td>${reservation.user.email}</td>
					<td><a href='<c:url value="/users/cancelReservation/${reservation.id}"/>'>cancel reservation</a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>