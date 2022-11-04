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
	<h1>JSON 응답 처리</h1>
	<h3>JavaScript Object Notation, 자바스크립트 객체 표기법</h3>
	
	<button id="btn1">/ex47/sub01 json 응답 처리</button>
	<br>
	<button id="btn2">/ex47/sub01 json 응답 처리2</button>
	<br>
	<button id="btn3">/ex47/sub02 json 응답 처리 연습</button>
	<br>
	<button id="btn4">/ex47/sub04 json 응답 처리 연습</button>
	<br>
	<br>
	
	<input id="inputCustomerId" type="number" placeholder="고객번호" value="${bean.id }" >
	<button id="btn6">/ex47/sub06 customer json 응답</button>
	<br>
	
	<input id="inputSupplierId" type="number" value="" placeholder="업체번호"> 
	<button id="btn7">ex47/sub07 supplier json 응답</button>
	<br>
	
	<%-- sub08 html에 출력하기 --%> 
	<br>
	<input type="number" placeholder="고객번호" id="customerIdInput8" value="1">
	<button id="btn8">/ex47/sub08/customerId, customer json 응답 </button>
	<div id="customerInfoDiv">
		id : <span class="id"></span> <br>
		name : <span class="name"></span> <br>
		city : <span class="city"></span> <br>
		country : <span class="country"></span>
	</div>
	
	<div id="messageDiv"></div>
	<br>
	<%-- sub09 html에 출력하기 --%> 
	<input type="number" placeholder="공급자번호" id="supplierIdInput9" value="1">

	<button id="btn9">/ex47/sub09/supplierId, supplier json 응답 </button>
	<div id="supplierInfoDiv">
		id : <span class="id"></span> <br>
		name : <span class="name"></span> <br>
		city : <span class="city"></span> <br>
		country : <span class="country"></span>
	</div>
	<div id="messageDiv2"></div>
	<br>
	
	<%-- sub10 update --%>
		<input type="text" id="customerIdInput10"  placeholder="id"> <br>
		<input type="text" id="customerNameInput10"  placeholder="name"> <br>
		<input type="text" id="customerContactNameInput10"  placeholder="contactName"> <br>
		<input type="text" id="customerAddressInput10"  placeholder="address"> <br>
		<input type="text" id="customerCityInput10"  placeholder="city"> <br>
		<input type="text" id="customerPostalCodeInput10"  placeholder="postalCode"> <br>
		<input type="text" id="customerCountryInput10"  placeholder="country"> <br>
	<%-- button --%>
	<button id="btn10">/ex47/sub10 put요청 고객정보 update</button>
	<%-- 조회 --%>
	<div id="messageDiv3"></div>
	
	<%-- sub13 공급자 저장 create --%>
	<input type="text" id="supplierNameInput13" placeholder="name">
	<input type="text" id="supplierContactNameInput13" placeholder="contactName">
	<input type="text" id="supplierAddressInput13" placeholder="address">
	<input type="text" id="supplierCityInput13" placeholder="city">
	<input type="text" id="supplierPostalCodeInput13" placeholder="postalCode">
	<input type="text" id="supplierCountryInput13" placeholder="country">
	<input type="text" id="supplierPhoneInput13" placeholder="phone">
	<br>
	<button id="#btn13">Create Supplier</button>
	<br>
	<div id="createSupplierDiv"></div>
	
	<input type="number" name="" id="deleteSupplierSub15" placeholder="삭제할 공급자 번호">
	<button id="btn15">공급자 번호 삭제 /ex47/sub15</button>
	
	
	
	
	
	
	<%-- ##########################################  script  ############################################### --%>
	<script>
		const ctx ="${pageContext.request.contextPath}" ;
		
		
		//***********sub15 delete **************
		document.querySelector("#btn15").addEventListener("click", function(){
			
			const data = document.querySelector("#deleteSupplierSub15").value;
			
			fetch(ctx +"/ex47/sub15", {
										method:"delete",
										headers :{ "Content-Type" : "application/json" },
										body : JSON.stringify(data) 
									  }
			)
			.then(response => response.json())
			.then(data => {document.querySelector("#deleteMessage").innerText = data.message});
		});
		
		//***********sub13 create **************
		document.querySelector("#btn13").addEventListener("click", function(){
			const name = document.querySelector("#supplierNameInput13").value;
			const contactName = document.querySelector("#supplierContactNameInput13").value;
			const address = document.querySelector("#supplierAddressInput13").value;
			const city = document.querySelector("#supplierCityInput13").value;
			const postalCode = document.querySelector("#supplierPostalCodeInput13").value;
			const country = document.querySelector("#supplierCountryInput13").value;
			const phone = document.querySelector("#supplierPhoneInput13").value;
			
			const data ={name, contactName, address, city, postalCode, country, phone};
			
			fetch(ctx + "/ex47/sub13", {
										method : "post",
										headers : { "Content-Type" : "application/json" },
										body : JSON.stringify(data)
										}
			)
			.then(response => response.json())
			.then(data => {document.querySelector("#createSupplierDiv").innerText = data.message});
		});
		
		
		//*********** sub10 update *************
		document.querySelector("#btn10").addEventListener("click", function(){ 
			const id = document.querySelector("#customerIdInput10").value;
			const name = document.querySelector("#customerNameInput10").value;
			const contactName = document.querySelector("#customerContactNameInput10").value;
			const address = document.querySelector("#customerAddressInput10").value;
			const city = document.querySelector("#customerCityInput10").value;
			const postalCode = document.querySelector("#customerPostalCodeInput10").value;
			const country = document.querySelector("#customerCountryInput10").value;
			
			const data = {id, name, contactName, address, city, postalCode, country};
			fetch(ctx + "/ex47/sub10",{
					method : "put",
					headers : {"Content-Type" : "application/json"},
					body : JSON.stringify(data)
			})
			.then(res => res.json())
			.then(d =>{
				document.querySelector("#messageDiv3").innerText = d.message;
			});
		});
		
		<%-- sub09 html에 출력하기 --%> 
		document.querySelector("#btn9").addEventListener("click", function(){
			document.querySelector("#messageDiv2").innerText = "";
			document.querySelector("#supplierInfoDiv .id").innerText = "";
			document.querySelector("#supplierInfoDiv .name").innerText = "";
			document.querySelector("#supplierInfoDiv .city").innerText = "";
			document.querySelector("#supplierInfoDiv .country").innerText = "";
			
			const id = document.querySelector("#supplierIdInput9").value;
			fetch(ctx + "/ex47/sub09/" + id)
			.then(response => response.json())
			.then(data =>{
				document.querySelector("#messageDiv2").innerText = data.message;
				document.querySelector("#supplierInfoDiv .id").innerText = data.supplier.id;
				document.querySelector("#supplierInfoDiv .name").innerText = data.supplier.name;
				document.querySelector("#supplierInfoDiv .city").innerText = data.supplier.city;
				document.querySelector("#supplierInfoDiv .country").innerText = data.supplier.country;
			});
		});
		
		<%-- sub08 html에 출력하기 --%> 
		document.querySelector("#btn8").addEventListener("click", function(){
			//텍스트 초기화
			//message 코드 먼저 작성해야 오류 안남
			document.querySelector("#messageDiv").innerText = "";  
			document.querySelector("#customerInfoDiv .id").innerText = "";
			document.querySelector("#customerInfoDiv .name").innerText = "";
			document.querySelector("#customerInfoDiv .city").innerText = "";
			document.querySelector("#customerInfoDiv .country").innerText = "";
			
			const id = document.querySelector("#customerIdInput8").value;
			fetch(ctx + "/ex47/sub08/" + id)
			.then(res => res.json())
			.then(data =>{
				// html에 출력
				//message 코드 먼저 작성해야 오류 안남
				document.querySelector("#messageDiv").innerText = data.message;
				document.querySelector("#customerInfoDiv .id").innerText = data.customer.id;
				document.querySelector("#customerInfoDiv .name").innerText = data.customer.name;
				document.querySelector("#customerInfoDiv .city").innerText = data.customer.city;
				document.querySelector("#customerInfoDiv .country").innerText = data.customer.country;
			});
		});
		
		//sub07
		document.querySelector("#btn7").addEventListener("click", function(){
			const id = document.querySelector("#inputSupplierId").value;
			fetch(ctx + "/ex47/sub07/" + id, {method : "get"})
			.then(res => res.json())
			.then(supplier => {
				
				console.log(supplier.id);
				
				console.log(supplier.name);
				
				console.log(supplier.contactName);
				
				console.log(supplier.address);
				
				console.log(supplier.city);
				
				console.log(supplier.postalCode);
				
				console.log(supplier.country);
				
				console.log(supplier.phone);
			});
			
			
			
		});
		
		// sub06
		document.querySelector("#btn6").addEventListener("click", function() {
			const id = document.querySelector("#inputCustomerId").value;
			fetch(ctx + "/ex47/sub06/" + id)
			.then(res => res.json())
			.then(customer => {
				console.log("id", customer.id);
				console.log("name", customer.name);
				console.log("contactName", customer.contactName);
				console.log("address", customer.address);
				console.log("city", customer.city);
				console.log("postalCode", customer.postalCode);
				console.log("country", customer.country);
			});
		});
	
		// 연습) sub04 리턴값(jdbc)
		document.querySelector("#btn4").addEventListener("click", function(){
			fetch(ctx + "/ex47/sub04")
			.then((res) => res.json())
			.then((cus) =>  {
				console.log(cus.id);
				console.log(cus.name);
				console.log(cus.contactName);
				console.log(cus.address);
				console.log(cus.city);
				console.log(cus.postalCode);
				console.log(cus.country);	
			});
		});	
		
		// 연습) blue,red,5,usa 출력 
		document.querySelector("#btn3").addEventListener("click", function(){
			fetch(ctx+ "/ex47/sub02")
			.then((response)=> response.json())
			.then((data) => {
				console.log("색상1 : ", data.color[0]);
				console.log("색상2 : ", data.color[1]);
				console.log("모델 : ", data.model);
				console.log("국가 : ", data.country);
			});
		});
	
		document.querySelector("#btn2").addEventListener("click", function(){
			fetch(ctx+ "/ex47/sub01")
			.then((res)=> res.json())
			.then((data)=> {console.log(data.name);
							console.log(data.job);
							console.log(data.address);
							}
			);
		});
		
		document.querySelector("#btn1").addEventListener("click", function(){
			fetch(ctx+ "/ex47/sub01")
			.then((res)=> res.json())
			.then((data)=> console.log(data));
		});
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>