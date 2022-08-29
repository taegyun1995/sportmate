<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="signinSec p-3">
		
			<div class="d-flex justify-content-center">
			
				<div class="d-flex justify-content-center align-items-center">
					<img width="100%" height="100%" src="/static/img/together.jpg" />
				</div>
		
				<div class="col-4 bg-white py-4 px-5">
				
					<h2> Login </h2>
					<div class="text-secondary"> <small> welcome! please login to your account </small> </div>
				
					<div>
						<form id="loginForm">
							<div class="pt-4">
								<input id="loginIdInput" class="signinBox form-control" type="text" placeholder="아이디"/>
							</div>
							
							<div class="pt-4 pb-2">
								<input id="passwordInput" class="signinBox form-control" type="password" placeholder="비밀번호"/>
							</div>
							
							<button type="submit" class="form-control mt-3" id="loginBtn"> 로그인 </button>
						</form>
						
						<div class="d-flex justify-content-around py-1">
							<div> <small> <a href="/sportmate/user/signup/view" class="text-dark"> 회원가입 </a> </small> </div>
							<div> <small> <a href="#" class="text-dark"> 아이디 찾기 </a> </small> </div>
							<div> <small> <a href="#" class="text-dark"> 비밀번호 찾기 </a> </small> </div>
						</div>
						
					</div>
					
					<button type="button" class="form-control mt-3 bg-warning"> 카카오로 시작하기 </button>
					<button type="button" class="form-control mt-1 bg-secondary"> 구글 시작하기 </button>
				
				</div>
		
			</div>
			
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		
	$("#loginForm").on("submit", function(e){
		e.preventDefault();
		
		let loginId = $("#loginIdInput").val();
		let password = $("#passwordInput").val();
		
		if(loginId == "") {
			alert("아이디를 입력하세요.")
			return;
		}
		
		if(password == "") {
			alert("비밀번호를 입력하세요.")
			return;
		}
		
		$.ajax({
			type:"post",
			url:"/user/signin",
			data:{"loginId":loginId, "password":password},
			
			success:function(data){
				if(data.result == "success") {
					location.href="/sportmate/main/home/view";
				} else {
					alert("아이디 / 비밀번호를 확인해주세요.");
				}
			},
			error:function(){
				alert("로그인 에러 발생!!");
			}
		});
		
	});
	
	
	
	</script>
	
</body>
</html>