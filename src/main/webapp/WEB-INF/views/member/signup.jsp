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
	<%-- tag_navbar_active: 경로 이동해줌 --%>
	<my:navBar active="signup"></my:navBar>
	<div>
		${message }
	</div>
	
	<div class="container-md">
		<div class="row">
			<div class="col">
				<h3>회원 가입</h3>
				
				<form action="" method="post">
					<div class="row">
						<div class="col-sm-1 ">
							<label for="staticId" class="form-label">ID</label>
						</div>
						<div class="col-sm-3 ">
							<input type="text" name="id" value="${member.id }" class="form-control" id="staticId">
						</div>
					</div>		
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label for="staticPw" class="form-label">비밀번호</label>					
						</div>
						<div class="col-sm-3 ">
							<input type="password" name="password" value="${member.password }" class="form-control" id="staticName">
						</div>
					</div>		
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label for="staticName" class="form-label">이름</label>
						</div>
						<div class="col-sm-3 ">	
							<input type="text" name="name" value="${member.name }" class="form-control" id="staticName">
						</div>
					</div>			
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label for="staticNickName" class="form-label">닉네임</label>
						</div>
						<div class="col-sm-3 ">
							<input type="text" name="nickname" value="${member.nickname }" class="form-control" id="staticNickName">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label for="exampleDataList" class="form-label">Email</label>
						</div>	
						<div class="col-sm-3" id="exampleEmailListInput" >
							<input type="email" name="email" value="${member.email }" class="form-control" list="datalistOptions" placeholder="abc@gmail.com">
							<datalist id="datalistOptions">		
								<option id="ex1"  value="">
								<option id="ex2"  value="">
								<option id="ex3"  value="">
								<option id="ex4"  value="">
							</datalist>
						</div>
					</div>
					<br>
					<input type="submit" value="회원가입">
					
				</form>
				
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script type="text/javascript">
		document.querySelector("#exampleEmailListInput").addEventListener('mouseover', (event) => {
			document.querySelector("#ex1").value = "@gmail.com";
			document.querySelector("#ex2").value = "@naver.com";
			document.querySelector("#ex3").value = "@daum.net";
			document.querySelector("#ex4").value = "@nate.com";
			
			
		});
	</script>
	
	</body>
</html>