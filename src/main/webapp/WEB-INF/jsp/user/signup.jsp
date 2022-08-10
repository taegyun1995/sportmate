<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	<div id="wrap">
		
		<header>
			<div class="h-100 d-flex justify-content-center align-items-center"> SportMate </div>
		</header>
		
		<section>
			<div class="d-flex py-1">
				<div class="photo d-flex align-items-center">
					<img width="550" height="400" src="/static/img/teamwork.png" />
				</div>
				<div class="signup">
					<div class="welcomeComment d-flex justify-content-center align-items-center"> 같이 운동할 사람 찾고 싶을 땐 SportMate </div>
					
					<div class="d-flex">
						<div class="signuplabel">
							<div class="labelword"> 아이디 </div>
							<div class="labelword"> 비밀번호 </div>
							<div class="labelword"> 이름 </div>
							<div class="labelword"> 주민등록번호 </div>
							<div class="labelword"> 연락처 </div>
							<div class="labelword2"> 이메일 </div>
							<div class="labelword2"> </div>
						</div>
						
						<div class="signupinput">
						
							<div class="inputword">
								<div class="d-flex">
									<input type="text" class="form-control col-4 mr-1" placeholder="아이디" id="idInput" />
									<button type="button" class="signupbtn btn col-2"> 중복확인 </button>
								</div>
								<div class="text-danger"> <small> 중복된 아이디입니다. </small> </div>
								<div class="text-success d-none"> <small> 사용가능한 아이디입니다. </small> </div>
							</div>
							
							<div class="inputword">
								<div class="d-flex">
									<input type="password" class="form-control col-4 mr-1" placeholder="비밀번호" />
									<input type="password" class="form-control col-4 mr-1" placeholder="비밀번호 확인" />
									<button type="button" class="signupbtn btn col-2"> 중복확인 </button>
								</div>
								<div class="text-success"> <small> 비밀번호가 일치합니다. </small> </div>
							</div>
							
							<div class="inputword">
								<input type="text" class="form-control col-4" placeholder="이름" />
							</div>
							
							<div class="inputword">
								<div class="d-flex">
									<input type="text" class="form-control col-4 mr-1" placeholder="주민등록번호 앞자리" />
									<div class="d-flex justify-content-center align-items-center"> - </div>
									<input type="text" class="form-control col-4 ml-1" placeholder="주민등록번호 뒷자리" />
								</div>
							</div>
							
							<div class="inputword">
								<input type="text" class="form-control col-5" placeholder="연락처" />
							</div>
							
							<div class="inputword2">
								<div class="d-flex">
									<input type="text" class="form-control col-4 mr-1" placeholder="sport" />
									<div class="d-flex justify-content-center align-items-center"> @ </div>
									<input type="text" class="form-control col-4 ml-1" placeholder="mate.com" />
									<button type="button" class="signupbtn btn col-2 ml-1"> 전송 </button>
								</div>
							</div>
							
							<div class="inputword2">
								<div class="d-flex">
									<input type="text" class="form-control col-4 mr-1" placeholder="인증번호" />
									<button type="button" class="signupbtn btn col-2"> 인증 </button>
								</div>
							</div>
							
						</div>
					</div>
					
					<div class="d-flex justify-content-center"> 
						<button type="button" class="signupbtn btn col-10 mt-3" id="addBtn"> 가입하기 </button>
					</div>
					
					<div class="d-flex justify-content-center">
						<div class="mt-3"> 계정이 있으신가요? </div>
						<a href="#" class="d-flex align-items-end ml-2"> 로그인 </a>
					</div>
					
				</div>
			</div>
		</section>
		
		<footer class="text-secondary d-flex align-items-end">
			CopyRights SportMate 
		</footer>
	
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#addBtn").on("click", function(){
				let id = $("#idInput").val();
				
				if(id == "") {
					alert("아이디를 입력해주세요.");
					return;
				}
			});
			
		});
	
	</script>
</body>
</html>