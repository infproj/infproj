<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="user-list">
	<table>
		<thead>
			<tr>
				
				<th>Name</th>
				<th>Surname</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="user" varStatus="status">
				<tr class="${(status.count % 2 == 0) ? 'even' : 'odd'}${status.last ? ' last' : ''}">
					<td>${user.year}</td>
					<td>${user.name}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>