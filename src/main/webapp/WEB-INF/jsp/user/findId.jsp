<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="d-flex justify-content-center py-3">
			<div class="col-5">
				<div class="d-flex justify-content-center align-items-center">
					<h2> ID/PW 찾기 </h2>
				</div>
				
				<div class="d-flex justify-content-center p-3 border-bottom">
					<button id="idfindBtn" class="bg-secondary text-white" type="button">아이디</button>
					<a href="/sportmate/user/change/pw/view"> <button id="pwfindBtn" type="button">비밀번호</button> </a>
				</div>
				
				
				<div class="d-flex justify-content-center pt-3"> <b> 등록된 휴대폰 번호로 찾기 </b> </div>
				<div class="d-flex justify-content-center pb-4"> <small> 가입 당시 입력한 이름과 연락처로 아이디를 찾을 수 있습니다. </small> </div>
				
				<div class="pl-5">
					<div class="pl-4">
						<label class="signupLabel"> 이름 </label>
						<input id="nameInput"  class="signupInput form-control col-10" type="text" placeholder="실명을 입력하세요."/>
						<label class="signupLabel pt-4"> 연락처 </label>
						<input id="phoneNumberInput"  class="signupInput form-control col-10" type="text" placeholder="'-' 구분없이 입력"/>
					</div>
				</div>
				
				<div class="d-flex justify-content-center py-3">
					<button id="loginIdfindBtn" class="col-7" type="button">아이디 찾기</button>
					 <a href="/sportmate/user/signin/view"> <button id="cancelBtn" class="col-12 ml-1" type="button"> 취소 </button></a>
				</div>
				
			</div>
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$("#loginIdfindBtn").on("click", function(){
			let name = $("#nameInput").val();
			let phoneNum = $("#phoneNumberInput").val();
			
			if(name == "") {
				alert("이름을 입력해주세요.");
				return;
			}
			if(phoneNum == "") {
				alert("연락처를 입력해주세요.");
				return;
			}
			
			$.ajax({
				type:"get",
				url:"/user/find/id",
				data:{"name":name, "phoneNum":phoneNum},
				
				success:function(data){
					if(data.result == "success"){
						alert("아이디 조회한 결과 " + data.loginId + "입니다.");
					} else {
						alert("회원정보를 다시 입력해주세요.");
					}
				},
				error:function() {
					alert("에러 발생!");
				}
			});
			
		});
	
	</script>
	
</body>
</html>