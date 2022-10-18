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
	<form action="${pageContext.request.contextPath }/ex13/sub01" method="get">
		이름 <input type="text" name="name" id="">
		주소 <input type="text" name="address" id="">
		<input type="submit" value="전송">
	</form>
	<hr>
	<form action="${pageContext.request.contextPath }/ex13/sub02" method="get">
		이름 <input type="text" name="name" id="">
		나이 <input type="number" name="age" id="">
		주소 <input type="text" name="address" id="">
		이메일 <input type="email" name="email" id="">
		비밀번호 <input type="password" name="password" id="">
		<input type="submit" value="전송">
	</form>
	<hr>
	<form action="${pageContext.request.contextPath }/ex13/sub03" method="get">
		Name <input type="text" name="name"/>	
		ClassName <input type="text" name="className"/>	
		Locatoin <input type="text" name="location"/>	
		Score <input type="text" name="score"/>	<%-- double 형변환은 spring method->JavaBean03 에서 해줌, 그래서 지금은 type text(String)로 보냈음. --%>
		Avg <input type="text" name="avg"/>		<%-- double 형변환은 spring method->JavaBean03 에서 해줌, 그래서 지금은 type text(String)로 보냈음. --%>
		<input type="submit" value="전송">
		
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>