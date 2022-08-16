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
		
		<section class="d-flex justify-content-center mt-3">
			<div class="signin col-4">
			
				<h2 class="login d-flex justify-content-center pb-3"> 로그인 </h2>
				
				<div class="border px-4 pt-1">
					<div class="signinlabel d-flex align-items-center pt-2"> 아이디 </div>
					<input type="text" class="signinInput form-control" placeholder="아이디"/>
					<div class="signinlabel d-flex align-items-center pt-4"> 비밀번호 </div>
					<input type="text" class="signinInput form-control" placeholder="비밀번호"/>
					<div class="text-danger pl-1"> <small> 다시 입력해주세요. </small> </div>
					<button type="button" class="signinbtn form-control mt-4"> 로그인 </button>
					<div class="d-flex">
						<div> <small> <a href="#"> 아이디 찾기 </a> </small> </div>
						<div class="pl-2"> <small> <a href="#"> 비밀번호 찾기 </a> </small> </div>
					</div>
					<div class="d-flex justify-content-center py-3">
						<div class="mt-3"> 계정이 없으신가요? </div>
						<a href="/sportmate/user/signup/view" class="d-flex align-items-end ml-2"> 회원가입 </a>
					</div>
				</div>
				
				<div class="orword d-flex justify-content-center"> 또는 </div>
				
			</div>
		
		
		</section>
		
		
		
		
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

</body>
</html>