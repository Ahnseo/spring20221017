<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
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
	<div>
		<my:navBar/>
	</div>
	<div class="container-md">
	  <div class="row">
	   <div class="col">   
		<h3>${board.id }번게시물 수정</h3>	
		<form id="modifyForm" action="" method="post">
		  <input type="hidden" name="id" value="${board.id }">
		  <div>
		    <label for="" class="form-label">제목</label>
		  </div>
		  <input class="form-control" type="text" name="title" value="${board.title }">
		 
		  <div>
			<label for="" class="form-label">본문</label>
		  </div>	
		  <textarea class="form-control" name="content">${board.content }</textarea>
		  
		  <div>
			<label for="" class="form-label">작성자</label>
		  </div>	
		  <input class="form-control" type="text" name="writer" value="${board.writer }">	
		  
		  <div>
			<label for="" class="form-label">작성일시</label>
		  </div>	
		  
		  <input class="form-control" type="datetime-local" value="${board.inserted }" readonly>
		</form>
		  
		<input type="submit" value="수정하기" data-bs-toggle="modal" data-bs-target="#modifyModal">
		
		<!-- modify Modal -->
		<div class="modal fade" id="modifyModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        수정하시겠습니까?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-primary" id="modifyConfirmButton" >확인</button>
		      </div>									<!-- id="modifyConfirmButton" 여기에 id설정 -->			
		    </div>
		  </div>
		</div>
	
		<c:url value="/board/remove" var="removeLink"/>
		
		<form id="removeForm" action="${removeLink }" method="post">
			<input type="hidden" name="id" value="${board.id }"> 
		</form>
		
		<input type="submit" value="삭제하기" data-bs-toggle="modal" data-bs-target="#removeModal">
		
		<!-- removeModal -->
		<div class="modal fade" id="removeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        삭제하시겠습니까?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-danger"    id="removeConfirmButton">삭제</button>
		      </div>                                       <!--  id="removeConfirmButton" 여기에 id설정 -->
		    </div>
		  </div>
		</div>
	    </div>
	  </div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous">
	</script>
		
	<script>
		document.querySelector("#modifyConfirmButton").addEventListener("click", function(){
			document.querySelector("#modifyForm").submit();
		});
		
		document.querySelector("#removeConfirmButton").addEventListener("click", function(){
			document.querySelector("#removeForm").submit();
		});
	</script>	
</body>

</html>