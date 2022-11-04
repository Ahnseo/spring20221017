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
	<h1>응답을 처리하는 방법</h1>
	
	<button id="btn1">ex46/sub01</button>
	<br>
	
	
	<button id="btn4">ex46/sub01 .then().then()</button>
	<br>
	<button id="btn5">ex46/sub01 .then().then() + ArrowFunction</button>
	<br>
	<button id="btn6">ex46/sub01 .then().then() + ArrowFunction_더 생략하기_응용1</button>
	<br>
	<button id="btn7">ex46/sub01 .then().then() + ArrowFunction_응용2</button>
	<br>
	<button id="btn8">ex46/sub01 .then().then() + ArrowFunction_응용3</button>
	<br>
	<button id="btn9">ex46/sub01 .then(response =>(response.text()) )</button>
	<br>
	
	<script>
	const ctx = "${pageContext.request.contextPath}";
	
	document.querySelector("#btn9").addEventListener("click", function () {
		fetch(ctx+"/ex46/sub01").then((response) => response.text())
								.then(data => console.log(data));
	})
	
	//then()+ ArrowFunction 연습3
	document.querySelector("#btn8").addEventListener("click", function(){
		fetch(ctx + "/ex46/sub01")
		.then(() => 3 )
		.then( a => console.log(a * 2) )// ?  6 
		.then( b => console.log(b * 2) ) // ?  NaN
		.then( c => console.log(c) ); // ?  x : undefined
	});
	
	//then()+ ArrowFunction 연습2
	document.querySelector("#btn7").addEventListener("click", function(){
		fetch(ctx + "/ex46/sub01")
		.then(() => 3 )
		.then( a => a * 2 )
		.then( b => console.log(b * 2) ); // 3 * 2 * 2 = 12
		
	});
	
	//then()+ ArrowFunction 연습1
	document.querySelector("#btn6").addEventListener("click", function(){
		
		fetch(ctx + "/ex46/sub01")
		.then(() => "a" )
		.then((v) => v + "b" )// "ab"
		.then( v => console.log(v) );
		
	});
	
	//then() 연습
	document.querySelector("#btn4").addEventListener("click", function(){
		
		fetch(ctx + "/ex46/sub01")
		.then(function(){
			return "a";	
		})
		.then(function(v){
			return v + "b"; // "ab"	
		})
		.then(function(v){
			console.log(v); // "ab"	
		});
		
	});
	
	
	document.querySelector("#btn1").addEventListener("click", function(){
		
		console.log("1번 statement");
		
		fetch(ctx + "/ex46/sub01").then(function(){
			
			console.log("2번 statement: fetch실행한 다음에 실행되어야하는 코드");
		});
		console.log("3번 statement: 상관없이 계속 실행되는 코드");
	});
	
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>