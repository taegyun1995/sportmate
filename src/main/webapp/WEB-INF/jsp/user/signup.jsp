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
</head>
<body>
	<div id="wrap">
		
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<hr>
		
		<section class="py-5">
		
			<div class="d-flex p-2">
			
				<div class="d-flex justify-content-center align-items-center col-6">
					<img width="550" height="350" src="/static/img/teamwork.png" />
				</div>
				
				<div class="col-6">
					<h5 class="welcome text-center text-secondary mb-4"> 같이 운동할 사람 찾고 싶을 땐 SportMate </h5>
					
					<div class="d-flex">
						<div class="col-2.5">
							<div class="signupBox d-flex align-items-center"> 아이디 </div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							<div class="signupBox d-flex align-items-center"> 비밀번호 </div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							<div class="signupBox d-flex align-items-center"> 이름 </div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							<div class="signupBox d-flex align-items-center"> 주민등록번호 </div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							<div class="signupBox d-flex align-items-center"> 연락처 </div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							<div class="signupBox d-flex align-items-center"> 이메일 </div>
							<div class="signupBox3 d-flex align-items-center">  </div>
							<div class="signupBox d-flex align-items-center">  </div>
						</div>
						
						<div class="col-9">
							<div class="signupBox d-flex">
								<input type="text" placeholder="아이디" class="form-control col-5" />
								<button type="button" class="btn col-3 ml-1" id="overLapBtn"> 중복확인 </button>
							</div>
							<div class="signupBox2 d-none"> <small class="d-flex align-items-start text-danger"> 중복된 아이디입니다. </small> </div>
							<div class="signupBox2"> <small class="d-flex align-items-start text-success"> 사용가능한 아이디입니다. </small> </div>
							
							<div class="signupBox d-flex">
								<input type="password" placeholder="패스워드" class="form-control col-4" />
								<input type="password" placeholder="패스워드" class="form-control col-4 ml-1" />
							</div>
							<div class="signupBox2"> <small class="d-flex align-items-start text-success"> 비밀번호가 일치합니다. </small> </div>
							
							<div class="signupBox">
								<input type="text" placeholder="이름" class="form-control col-5" />
							</div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							
							<div class="signupBox d-flex">
								<input type="password" placeholder="생년월일" class="form-control col-5" />
								<div class="d-flex justify-content-center align-items-center mx-1"> - </div>
								<input type="password" placeholder="주민등록번호" class="form-control col-5" />
							</div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							
							<div class="signupBox">
								<input type="text" placeholder="연락처" class="form-control col-5" />
							</div>
							<div class="signupBox2 d-flex align-items-center">  </div>
							
							<div class="signupBox d-flex">
								<input type="password" placeholder="패스워드" class="form-control col-4" />
								<div class="d-flex justify-content-center align-items-center mx-1"> @ </div>
								<input type="password" placeholder="패스워드" class="form-control col-4" />
								<button type="button" class="btn col-3 ml-1" id="sendBtn"> 전송 </button>
							</div>
							<div class="signupBox3 d-flex align-items-center">  </div>
							
							<div class="signupBox d-flex">
								<input type="text" placeholder="인증번호" class="form-control col-4" />
								<button type="button" class="btn col-3 ml-1" id="certBtn"> 인증 </button>
							</div>
						</div>
					</div>
					
				<div class="d-flex justify-content-center pt-4">
					<button type="button" class="btn col-8" id="addBtn"> 가입하기 </button>
				</div>
				
				</div>
				
			</div>
			
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#addBtn").on("click", function(){
				let id = $("#idInput").val();
				let pw = $("#pwInput").val();
				let repw = $("#pwReInput").val();
				let name = $("#name").val();
				let firstsecNum = $("#FirstsecNum").val();
				let lastsecNum = $("#LastsecNum").val();
				let phoneNum = $("#phoneNum").val();
				let email = $("#email").val();
				
				if(id == "") {
					alert("아이디를 입력해주세요.");
					return;
				}
				
				if(pw == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				
				if(name == "") {
					alert("이름을 입력해주세요.");
					return;
				}
				
				if(firstsecNum == "") {
					alert("주민등록번호를 입력해주세요.");
					return;
				}
				
				if(lastsecNum == "") {
					alert("주민등록번호를 입력해주세요.");
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