<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<h3>공급자 정보 수정</h3>
	<%-- Get : id --%>
	<form action="" method="get">
		<input type="number" name="id" value="${supplier.id }" placeholder="공급자id 입력">
		<input type="submit" value="전송">
	</form>
	<hr>
	<%-- Post: get에서 불러온 정보들을 업뎃 --%>
	<form action="" method="post">
		<input type="number" name="id" value="${supplier.id }" readonly="readonly"> <br>
		<input type="text" name="name" value="${supplier.name }"><br>
		<input type="text" name="contactName" value="${supplier.contactName }"><br>
		<input type="text" name="address" value="${supplier.address }"><br>
		<input type="text" name="city" value="${supplier.city }"><br>
		<input type="text" name="postalCode" value="${supplier.postalCode }"><br>
		<input type="text" name="country" value="${supplier.country }"><br>
		<input type="text" name="phone" value="${supplier.phone }">
		
		<input type="submit" value="업데이트 하기">
	</form>
	
	<c:if test="${not empty message }">
		<div>
			${message }
		</div>
	</c:if>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>