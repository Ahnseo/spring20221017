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
	<h3>fetch 요청방식 변경 sub0.jsp</h3>
	
	<button id="btn1">버튼1 /ex40/sub01.jsp Get방식요청</button>
	<br>
	
	<button id="btn2">버튼2 /ex40/sub02.jsp Get방식요청 w/ option</button>
	<br>
	
	<button id="btn3">버튼3 /ex40/sub03.jsp Post방식요청 w/ option</button>
	<br>
	<br>
	
	<p>Get / Post 연습</p>
	<button id="btnGet">/ex40/sub04 get방식 fetch요청</button>
	<button id="btnPost">/ex40/sub04 post방식 fetch요청</button>
	<br>
	<br>
	
	<button id="btn6">/ex40/sub04 Put방식 fetch요청</button>
	<button id="btn7">/ex40/sub04 Delete방식 fetch요청</button>
	
	<br><br>
	
	<!-- (br+button#btn$@8)*4 -->
	<p> C R U D </p>
	
	<button id="btn8">/ex40/sub05 get(R) 방식 요청</button>
	<br>
	<button id="btn9">/ex40/sub05 post(C) 방식 요청</button>
	<br>
	<button id="btn10">/ex40/sub05 put(U) 방식 요청</button>
	<br>
	<button id="btn11">/ex40/sub05 delete(D) 방식 요청</button>
	
	<script>
		const contextPath ="${pageContext.request.contextPath}" 
		
		document.querySelector("#btn8").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub05");
		});
		document.querySelector("#btn9").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub05", {method : "post"});
		});
		document.querySelector("#btn10").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub05", {method : "put"});
		});
		document.querySelector("#btn11").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub05", {method : "delete"});
		});
		
		
		document.querySelector("#btn7").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub04", {method : "delete"});
		});
		
		document.querySelector("#btn6").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub04", {method : "put"});
		});
		
		//연습 sub04 get,post방식 요청
		document.querySelector("#btnGet").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub04", {method : "get"});
		});
		document.querySelector("#btnPost").addEventListener("click", function(){
			fetch(contextPath + "/ex40/sub04", {method : "post"});
		});
		
		
		document.querySelector("#btn3").addEventListener("click", function(){
			//fetch에 두번째 파라미터는 options(Object)
			fetch(contextPath + "/ex40/sub03", {method : "post"});		
		});
		
		document.querySelector("#btn2").addEventListener("click", function(){
			//fetch에 두번째 파라미터는 options(Object)
			fetch(contextPath + "/ex40/sub02", {method : "get"});	
		});
		
		document.querySelector("#btn1").addEventListener("click", function(){
			//아무 옵션을 주지않으면, get 방식
			fetch(contextPath + "/ex40/sub01");	
		});
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>