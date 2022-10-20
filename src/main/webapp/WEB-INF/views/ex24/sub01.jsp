<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<h1>ex24/sub01.jsp</h1>

	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>contactName</th>
				<th>address</th>
				<th>city</th>
				<th>postalCode</th>
				<th>country</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customerList }" var="c">
				<tr>
					<td>${c.customerID }</td>
					<td>${c.customerName }</td>
					<td>${c.contactName }</td>
					<td>${c.address }</td>
					<td>${c.city }</td>
					<td>${c.postalCode }</td>
					<td>${c.country }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${pageInfo.leftPage != 1 }">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/ex24/sub02?page=${pageInfo.firstPage }">맨앞페이지</a></li>
				</c:if>

				<c:forEach begin="${pageInfo.leftPage }" end="${pageInfo.rightPage }" var="pageNumber">

					<c:url value="/ex24/sub02" var="pageLink">
						<c:param name="page" value="${pageNumber} "></c:param>
					</c:url>

					<li
						class="page-item ${pageInfo.current eq pageNumber ? 'active' : '' }"><a
						class="page-link" href="${pageLink }">${pageNumber }</a></li>

				</c:forEach>
				<%-- 페이지 갯수를 10을 맞춰놓았는데, 마지막으로 다다를때쯤 9,8,7 ... 10 아래로 줄어들지? --%>
				<c:if test="${pageInfo.rightPage != pageInfo.lastPage }">
					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ex24/sub02?page=${pageInfo.lastPage}">마지막페이지</a></li>
				</c:if>
				
			</ul>
		</nav>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>