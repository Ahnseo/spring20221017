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
	<form action="" method="post">
		<input type="text" name="SupplierName" id="" placeholder="공급자명">
		<input type="text" name="ContactName" id="" placeholder="닉네임">
		<input type="text" name="Address" id="" placeholder="주소">
		<input type="text" name="City" id="" placeholder="도시">
		<input type="text" name="PostalCode" id="" placeholder="우편번호">
		<input type="text" name="Country" id="" placeholder="국가">
		<input type="text" name="Phone" id="" placeholder="전화번호">
		<input type="submit" value="등록">
	</form>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>공급자명</th>
				<th>닉네임</th>
				<th>주소</th>
				<th>도시</th>
				<th>우편번호</th>
				<th>국가</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${supplier.supplierID} </td>
				<td>${supplier.supplierName} </td>
				<td>${supplier.contactName} </td>
				<td>${supplier.address} </td>
				<td>${supplier.city} </td>
				<td>${supplier.postalCode} </td>
				<td>${supplier.country} </td>
				<td>${supplier.phone} </td>		
			</tr>
		</tbody>
	</table>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>공급자명</th>
				<th>닉네임</th>
				<th>주소</th>
				<th>도시</th>
				<th>우편번호</th>
				<th>국가</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${supplierList }" var="s" >
					<td>${s.supplierID }</td>
					<td>${s.supplierName }</td>
					<td>${s.contactName }</td>
					<td>${s.address }</td>
					<td>${s.city }</td>
					<td>${s.postalCode }</td>
					<td>${s.country }</td>
					<td>${s.phone }</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>