<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
</head>
<body>
	<div id="wrap">
		
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="py-2">
		
			<div class="d-flex justify-content-center">
			
				
				<div class="col-5 border">
					<h3 class="text-center my-4"> SIGN UP </h3>
					<div class="text-center text-secondary border-bottom pb-1"> 같이 운동할 사람 찾고 싶을 땐 SportMate </div>
					
					<div class="d-flex px-3 py-4">
						<div>
							<label class="signupLabel"> 아이디 </label>
							<div class="d-flex">
								<input id="loginIdInput" class="signupInput form-control col-12 border-none" type="text" placeholder="아이디"  />
								<button id="overLapBtn" class="col-3 ml-1" type="button"> 중복확인 </button>
							</div>
							
							<label class="signupLabel  pt-2"> 비밀번호 </label>
							<div class="d-flex">
								<input id="passwordInput" class="signupInput form-control col-6" type="password" placeholder="비밀번호" />
								<input id="confrimPasswordInput" class="signupInput form-control col-6 ml-1" type="password" placeholder="비밀번호 확인"/>
							</div>
							
							<label class="signupLabel  pt-2"> 이름 </label>
							<input id="nameInput"  class="signupInput form-control" type="text" placeholder="실명을 입력하세요."/>
							 
							<label class="signupLabel  pt-2"> 연락처 </label>
							<input id="phoneNumInput"  class="signupInput form-control" type="text" placeholder="'-' 구분없이 입력"/>
							
							<label class="signupLabel  pt-2"> 생년월일 </label>
							<input id=""  class="signupInput form-control" type="password" placeholder="8자리 입력"/>
						
							<label class="signupLabel pt-2"> 성별 </label>
							<div class="signupInput d-flex align-items-center">
								<input type="checkbox"/>
								<label class="ml-1"> 남성 </label>
								<input class="ml-5" type="checkbox"/>
								<label class="ml-1"> 여성 </label>
							</div>
							 
							<label class="signupLabel pt-2"> 이메일 </label>
							<div class="d-flex">
								<input class="signupInput form-control col-12" id="emailIdInput" type="email" placeholder="sportmate@example.com"/>
								<button id="sendBtn"  class="col-3 ml-1" type="button"> 전송 </button>
							</div>
							
							<label class="signupLabel pt-2"> 인증번호 </label>
							<input id="certificationNumber" class="signupInput form-control" type="text" placeholder="인증번호 입력"/>
						</div>
						
					</div>
					
				<div class="d-flex justify-content-center px-3">
					<button id="addBtn" class="col-12 ml-1" type="button"> 가입하기 </button>
				</div>
				
				<div class="d-flex justify-content-center my-3">
					<div> <small> 계정이 있으신가요? </small> </div>
					<a href="/sportmate/user/signin/view" class="ml-2"> <small> 로그인 </small> </a>
				</div>
				
				</div>
				
			</div>
			
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#overLapBtn").click(function () {
				let loginId = $("#loginIdInput").val();
		
		 		Swal.fire({
			    	icon: 'success',
			    	title: '사용가능한 아이디입니다.',
			    	text: '회원가입을 진행해주세요.',
		   		});
			});
			
			$("#addBtn").on("click", function(){
				let loginId = $("#loginIdInput").val();
				let password = $("#passwordInput").val();
				let confrimPassword = $("#confrimPasswordInput").val();
				let name = $("#nameInput").val();
				let phoneNum = $("#phoneNumInput").val();
				let email = $("#emailInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력해주세요.");
					return;
				}
				if(password == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(confrimPassword == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(password != confrimPassword) {
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				if(name == "") {
					alert("이름을 입력해주세요.");
					return;
				}
				if(phoneNum == "") {
					alert("연락처를 입력해주세요.");
					return;
				}
				if(email == "") {
					alert("이메일을 입력해주세요.");
					return;
				}
				
				
			});
			
			
		});
	
	</script>
</body>
</html>