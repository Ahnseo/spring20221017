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
	<my:navBar></my:navBar>
	<div class="container-md">
		<div class="row">
			<div class="col">
				<c:if test="${not empty message }"  >
				    <div class="alert alert-success">
				    	${message }
				    </div>
			  	</c:if>
				<h3>회원 정보 수정</h3>

				<form id="updateMemberForm" action="" method="post" >
					<div class="row">
						<div class="col-sm-1 ">
							<label class="form-label">ID<br>(변경불가)</label>
						</div>
						<div class="col-sm-3 ">
							<input type="text"  placeholder="${member.id }" class="form-control" disabled readonly>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label class="form-label">비밀번호</label>
						</div>
						<div class="col-sm-3 ">	
							<input type="text" name="password" value="${member.password }" class="form-control" id="currentPassword">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label class="form-label">이름<br>(변경불가)</label>
						</div>
						<div class="col-sm-3 ">
							<input type="text"  value="${member.name }" class="form-control" disabled readonly>			
						</div>
					</div>	
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label class="form-label">닉네임</label>		
						</div>
						<div class="col-sm-3 ">
							<input type="text" name="nickname" value="${member.nickname }" class="form-control">
						</div>
					</div>						
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label class="form-label">Email</label>	
						</div>
						<div class="col-sm-3 ">
							<input type="email" name="email" value="${member.email }" class="form-control">				
						</div>
					</div>		 
					<br>
					<div class="row">
						<div class="col-sm-1 ">
							<label class="form-label">가입일시<br>(변경불가)</label>
						</div>
						<div class="col-sm-3 ">
							<input type="text" value="${member.inserted }" class="form-control" disabled readonly>
						</div>
					</div>	
					<br>
					<input type="hidden" value="${member.password }" readonly id="previousPassword"> <%-- hidden 에 name="" 쿼리스트링 주면 안돼!! 그냥 받아오는것뿐이야. --%>
					<%-- (수정 다시 물어보기) jsp 모달  --%>
					<!-- <input type="submit" value="회원정보 수정"> -->
				</form>
				
				<c:url value="/member/remove" var="removeLink"/>
				<form id="removeMemberForm" action="${removeLink }" method="post" class="mb-3">
					<input type="hidden" name="id" value="${member.id }">
					<input type="hidden" id="previousPasswordInRemoveMemberForm" value="${member.password }"><%-- hidden 에 name="" 쿼리스트링 주면 안돼!! 그냥 받아오는것뿐이야. --%>
					<%-- (탈퇴 다시 물어보기) jsp 모달  --%>
					<%-- <input type="submit" value="회원 탈퇴"> --%>
				</form>
				<button id="updateMemberButton" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateMemberModal">회원 수정</button>
				<button id="removeMemberButton" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#removeMemberModal">회원 탈퇴</button>
			</div>
		</div>
	</div>
	
	<!-- 회원 탈퇴 모달 -->
	<div class="modal fade" id="removeMemberModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">회원 탈퇴</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<input type="text" class="form-control" id="currentPasswordInRemoveMemberForm" placeholder="탈퇴를 진행하시려면, 비밀번호를 입력하세요.">
	      	<br>
	        회원 탈퇴 하시겠습니까?
	        <div id="failMessage">
	        </div>
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button id="removeMemberModalSubmit" type="button" class="btn btn-danger">탈퇴</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 회원 정보 수정 모달 -->
	<div class="modal fade" id="updateMemberModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">회원 정보 수정</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	
	      	이전 비밀번호 <input id="previousPasswordInModal" type="text" class="form-control">
	      	<br>
	      	수정한 비밀번호 <input id="currentPasswordInModal" type="text" class="form-control">
	      	<br>
	        수정 하시겠습니까?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button id="updateMemberModalSubmit" type="button" class="btn btn-primary">수정</button>
	      </div>
	    </div>
	  </div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script>
	<!-- 회원 탈퇴 모달 -->
	document.querySelector("#removeMemberButton").addEventListener("click", function(){
		//모달 암포 인풋 입력되 값을 -> 폼 안의 기존암호 인풋에 옴기고 -> 폼을 서브밋
		const removeMemberForm = document.forms.removeMemberForm;
		const previousPasswordInRemoveMemberForm = document.querySelector("#previousPasswordInRemoveMemberForm").value;
		/* console.log(previousPasswordInRemoveMemberForm); 확인 됨*/
		
		document.querySelector("#removeMemberModalSubmit").addEventListener("click", function(){
			const currentPasswordInRemoveMemberForm = document.querySelector("#currentPasswordInRemoveMemberForm").value;
			/* console.log(currentPasswordInRemoveMemberForm); 확인 됨*/
			if (previousPasswordInRemoveMemberForm == currentPasswordInRemoveMemberForm) {
				document.querySelector("#removeMemberForm").submit();
			}else{
				document.querySelector("#failMessage").innerHTML = "비밀번호가 일치하지 않습니다.";
			}
		});
	});
	
	<!-- 회원 정보 수정 모달 -->
	document.querySelector("#updateMemberButton").addEventListener("click", function(){
		//모달 암포 인풋 입력되 값을 -> 폼 안의 기존암호 인풋에 옴기고 -> 폼을 서브밋
		const updateMemberForm = document.forms.updateMemberForm;
		const previousPassword = document.querySelector("#previousPassword").value;
		const currentPassword = document.querySelector("#currentPassword").value;
		console.log(previousPassword);
		console.log(currentPassword);
		
		document.querySelector("#previousPasswordInModal").value = previousPassword;
		document.querySelector("#currentPasswordInModal").value = currentPassword;
		
		document.querySelector("#updateMemberModalSubmit").addEventListener("click", function(){
			document.querySelector("#updateMemberForm").submit();
		});
	});
	
	</script>
	

</body>
</html>