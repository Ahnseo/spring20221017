<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>ex48/sub.jsp 여러 데이더 얻기</h1>
	<h3>`` : 백틱을 사용하면, el 코드 사용할수있다.</h3>
	
	<div id="result1"></div>
	
	<button id="btn1"> /ex48/sub01 get , customer list(array)</button>
	<button id="btn2"> /ex48/sub02 get , supplier list(table)</button>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>name</th>
				<th>contactName</th>
				<th>address</th>
				<th>city</th>
				<th>postalCode</th>
				<th>country</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody id="supplierTableBody" >
		<c:forEach items="${supplierList }" var="supplier">
			<tr>
				<td>${supplier.id }</td>
				<td>${supplier.name }</td>
				<td>${supplier.contactName }</td>
				<td>${supplier.address }</td>
				<td>${supplier.city }</td>
				<td>${supplier.postalCode }</td>
				<td>${supplier.country }</td>
				<td>${supplier.phone }</td>				
			</tr>
		</c:forEach>
		</tbody>	
	</table>
	
	
	<script>
		const ctx ="${pageContext.request.contextPath}" ;
		
		document.querySelector("#btn2").addEventListener("click", function(){
			
			fetch( ctx +"/ex48/sub02")
			.then(res => res.json())
			.then(list => {
				//JS 안에서의 for문 사용방법
				for(const item of list){
					const tableRow = 
					`<tr>
						<td>\${item.id}</td>
						<td>\${item.name}</td>
						<td>\${item.contactName}</td>
						<td>\${item.address}</td>
						<td>\${item.city}</td>
						<td>\${item.postalCode}</td>
						<td>\${item.country}</td>
						<td>\${item.phone}</td>	
					</tr>`;
					
					document.querySelector("#supplierTableBody").insertAdjacentHTML("beforeend", tableRow);
				}	
			})
		});
		
		document.querySelector("#btn1").addEventListener("click", function(){
			
			fetch( ctx +"/ex48/sub01")
			.then(res => res.json())
			.then(list => {
				//JS 안에서의 for문 사용방법
				for(const item of list){
					console.log(`\${item.id}번은 \${item.name}`);
					const listItem = `<li>\${item.id}번은 \${item.name}</li>`;
					
					document.querySelector("#result1").insertAdjacentHTML("beforeend", listItem);
				}	
			})
		});
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>