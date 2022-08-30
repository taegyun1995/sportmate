<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
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
					<a href="/sportmate/user/find/id/view"> <button id="idfindBtn" type="button">아이디</button> </a>
					<button id="pwfindBtn" class="bg-secondary text-white" type="button">비밀번호</button> 
				</div>
				
				
				<div class="d-flex justify-content-center pt-3"> <b> 등록된 이메일로 변경하기 </b> </div>
				<div class="d-flex justify-content-center pb-4"> <small> 가입 당시 입력한 이름과 이메일로 비밀번호를 찾을 수 있습니다. </small> </div>
				
				<div class="pl-5">
					<div class="idemailBox pl-4">
						<label class="signupLabel"> 아이디 </label>
						<input id="loginIdInput"  class="signupInput form-control col-10" type="text" placeholder="아이디"/>
						<label class="signupLabel pt-4"> 이메일 </label>
						<input id="emailInput"  class="signupInput form-control col-10" type="text" placeholder="이메일"/>
					</div>
					<div class="pwBox pl-4 d-none">
						<label class="signupLabel"> 비밀번호 </label>
						<input id="passwordInput"  class="signupInput form-control col-10" type="text" placeholder="비밀번호"/>
						<label class="signupLabel pt-4"> 비밀번호 확인 </label>
						<input id="confirmpasswordInput"  class="signupInput form-control col-10" type="text" placeholder="비밀번호 확인"/>
					</div>
				</div>
				
				<div class="idemailBox">
					<div class="d-flex justify-content-center py-3">
						<button id="passwordfindBtn" class="col-7" type="button">조회하기</button>
						 <a href="/sportmate/user/signin/view"> <button id="cancelBtn" class="col-12 ml-1" type="button"> 취소 </button></a>
					</div>
				</div>
				<div class="pwBox d-none">
					<div class="d-flex justify-content-center py-3">
						<button id="passwordchangeBtn" class="col-7" type="button">비밀번호 변경</button>
						 <a href="/sportmate/user/signin/view"> <button id="cancelBtn" class="col-12 ml-1" type="button"> 취소 </button></a>
					</div>
				</div>
				
			</div>
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$("#passwordfindBtn").on("click", function() {
			let loginId = $("#loginIdInput").val();
			let email = $("#emailInput").val();
			
			if(loginId == "") {
				alert("아이디를 입력해주세요.");
				return;
			}
			if(email == "") {
				alert("이메일을 입력해주세요.");
				return;
			}
			
			$.ajax({
				type:"get",
				url:"/user/overlap/password",
				data:{"loginId":loginId, "email":email},
				
				success:function(data){
					if(data.overlap){
						$(".pwBox").removeClass("d-none");
						$(".idemailBox").addClass("d-none");
					} else {
						$(".pwBox").addClass("d-none");
						$(".idemailBox").removeClass("d-none");
					}
				},
				error:function(){
					alert("에러발생");
				}
				
			});
			
			$("#passwordchangeBtn").on("click", function(){
				let loginId = $("#loginIdInput").val();
				let email = $("#emailInput").val();
				let password = $("#passwordInput").val();
				let confirmpassword = $("#confirmpasswordInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력해주세요.");
					return;
				}
				if(email == "") {
					alert("이메일을 입력해주세요.");
					return;
				}
				if(password != confirmpassword) {
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/user/change/password",
					data:{"password":password, "loginId":loginId, "email":email},
					
					success:function(data) {
						if(data.result == "success") {
							location.href="/sportmate/user/signin/view";
						} else {
							alert("비밀번호 변경 실패");
						}
					},
					error:function() {
						alert("에러발생!");
					}
				});
				
			});
			
			
			
		});
	
	</script>
</body>
</html>