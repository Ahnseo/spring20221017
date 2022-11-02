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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>Accept 요청 해더를 처리하는 콘트롤러 메소드</h1>
	<button id="btn1">/ex42/sub01 요청</button>
	<br>
	<button id="btn2">/ex42/sub02 요청</button>
	<br>
	
	<script>
		const contextPath = "${pageContext.request.contextPath}";
		
		document.querySelector("#btn2").addEventListener("click", function(){
			fetch(contextPath + "/ex42/sub02",{
				method : "get",
				headers : {"Accept" : "text/html"}
				 
			});
		});
		
		document.querySelector("#btn1").addEventListener("click", function(){
			fetch(contextPath + "/ex42/sub01",{
				method : "get",
				headers : {"Accept" : "text/plain"}
			});
		});	
		
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>