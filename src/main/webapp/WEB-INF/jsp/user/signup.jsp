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
			
				
				<div class="col-5 border rounded">
					<h3 class="text-center my-4"> SIGN UP </h3>
					<div class="text-center text-secondary border-bottom pb-1"> 같이 운동할 사람 찾고 싶을 땐 SportMate </div>
					
					<div class="d-flex px-3 py-4">
						<div>
							<div class="d-flex justify-content-center py-2">
								<img id="preview-image" src="/static/img/profilePhoto.png" width="200" height="200"/>
							</div>
					
							<div class="d-flex justify-content-center">
								<div class="d-flex align-items-center">
									<a href="#" id="imageIcon" class="d-flex align-items-center text-dark"> <img width="15" src="/static/img/photo.png"/> Profile Photo </a>
									<input type="file" class="btn d-none" id="fileInput">
								</div>
							</div>
							
							<label class="signupLabel"> 아이디 </label>
							<div class="d-flex">
								<input id="loginIdInput" class="signupInput form-control col-9 border-none" type="text" placeholder="아이디"  />
								<button id="idoverLapBtn" class="col-3 ml-1" type="button"> 중복확인 </button>
							</div>
							
							<label class="signupLabel pt-2"> 비밀번호 </label>
							<div class="d-flex">
								<input id="passwordInput" class="signupInput form-control col-4.5" type="password" placeholder="비밀번호" />
								<input id="confrimPasswordInput" class="signupInput form-control col-4.5" type="password" placeholder="비밀번호 확인"/>
								<button id="pwoverLapBtn" class="col-3 ml-1" type="button"> 중복확인 </button>
							</div>
							
							<label class="signupLabel pt-2"> 이름 </label>
							<input id="nameInput"  class="signupInput form-control" type="text" placeholder="실명을 입력하세요."/>
							
							<label class="signupLabel pt-2"> 닉네임 </label>
							<input id="nickNameInput"  class="signupInput form-control" type="text" placeholder="닉네임을 입력하세요."/>
							 
							<label class="signupLabel pt-2"> 연락처 </label>
							<input id="phoneNumberInput"  class="signupInput form-control" type="text" placeholder="'-' 구분없이 입력"/>
							 
							<label class="signupLabel pt-2"> 생년월일 </label>
							<input id="birthInput"  class="signupInput form-control" type="text" placeholder="8자리 입력"/>
							
							<label class="signupLabel pt-2"> 성별 </label>
							<div class="d-flex genderBox">
							    <div>
							      <input type="radio" id="man" name="genderSelect" value="남">
							      <label for="man">남</label>
							    </div>
							    <div class="pl-3">
							      <input type="radio" id="woman" name="genderSelect" value="여">
							      <label for="woman">여</label>
							    </div>
							</div>
							
							<label class="signupLabel"> 운동종목 </label>
							<select id="exerciseSelect" class="signupInput form-control" name="exerciseSelect">
								<option value="none"> 선택하시오. </option>
								<option value="축구"> 축구 </option>
								<option value="농구"> 농구 </option>
								<option value="헬스"> 헬스 </option>
							</select>
							
							<label class="signupLabel"> 지역 </label>
							<select id="regionSelect" class="signupInput form-control" name="regionSelect">
								<option value="none"> 선택하시오. </option>
								<option value="서울"> 서울 </option>
								<option value="경기"> 경기 </option>
								<option value="부산"> 부산 </option>
							</select>
							
							<label class="signupLabel pt-2"> 자기소개 </label>
							<textarea class="form-control" rows="3" id="contentInput"> </textarea>
							
							<label class="signupLabel pt-2"> 이메일 </label>
							<input id="emailInput"  class="signupInput form-control" type="text" placeholder="이메일"/>
							 
						</div>
					</div>
					
				<div class="d-flex justify-content-center px-3">
					<button id="signupBtn" class="col-12 ml-1" type="button"> 가입하기 </button>
				</div>
				
				<div class="d-flex justify-content-center my-3">
					<div> <small> 계정이 있으신가요? </small> </div>
					<a href="/sportmate/user/signin/view" class="ml-2"> <small class="text-dark"> 로그인 </small> </a>
				</div>
				
				</div>
				
			</div>
			
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function(){
			
			function readImage(input) {
			    // 인풋 태그에 파일이 있는 경우
			    if(input.files && input.files[0]) {
			        // 이미지 파일인지 검사 (생략)
			        // FileReader 인스턴스 생성
			        const reader = new FileReader()
			        // 이미지가 로드가 된 경우
			        reader.onload = e => {
			            const previewImage = document.getElementById("preview-image")
			            previewImage.src = e.target.result
			        }
			        // reader가 이미지 읽도록 하기
			        reader.readAsDataURL(input.files[0])
			    }
			}
			// input file에 change 이벤트 부여
			const inputImage = document.getElementById("fileInput")
			inputImage.addEventListener("change", e => {
			    readImage(e.target)
			})
		
			$("#imageIcon").on("click", function(e) {
				// fileInput을 클릭한 효과를 만들어야 한다.
				e.preventDefault(); // 이벤트 안 고유의 기능을 제거 
				$("#fileInput").click();
			});
			
			var idOverlapCheck = false;
			var idOverlapId = true;
			var pwOverlapCheck = false;
			var pwOverlapId = true;
			
			$("#idoverLapBtn").on("click", function(){
				let loginId = $("#loginIdInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요.");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/user/overlap_id",
					data:{"loginId":loginId},
					
					success:function(data) {
						
						idOverlapCheck = true;
						
						if(!data.overlap) {
					 		Swal.fire({
						    	icon: 'success',
						    	title: '사용가능한 아이디입니다.',
						    	text: '회원가입을 진행해주세요.',
					   		});
					 		idOverlapId = false;
						} else {
					 		Swal.fire({
						    	icon: 'error',
						    	title: '중복된 아이디입니다.',
						    	text: '다른 아이디를 입력해주세요.',
					   		});
					 		idOverlapId = true;
						}
					},
					error:function() {
						alert("중복확인 에러");
					}
				});
				
			});
			
			$("#pwoverLapBtn").on("click", function(){
				let password = $("#passwordInput").val();
				let confrimPassword = $("#confrimPasswordInput").val();
				
				pwOverlapCheck = true;
				
				if(password == confrimPassword) {
			 		Swal.fire({
				    	icon: 'success',
				    	title: '사용가능한 비밀번호 입니다.',
				    	text: '회원가입을 진행해주세요.',
			   		});
			 		pwOverlapId = false;
				} else {
			 		Swal.fire({
				    	icon: 'error',
				    	title: '비밀번호가 일치하지 않습니다.',
				    	text: '다시 입력해주세요.',
			   		});
			 		pwOverlapId = true;
				}
				
			});
			
			$("#signupBtn").on("click", function(e){
				e.preventDefault();
				
				let loginId = $("#loginIdInput").val();
				let password = $("#passwordInput").val();
				let confrimPassword = $("#confrimPasswordInput").val();
				let name = $("#nameInput").val();
				let nickName = $("#nickNameInput").val();
				let phoneNum = $("#phoneNumberInput").val();
				let birth = $("#birthInput").val();
				let gender = $("input[name=genderSelect]").val();
				let exercise = $("#exerciseSelect").val();
				let region = $("#regionSelect").val();
				let content = $("#contentInput").val();
				let email = $("#emailInput").val();
				
				if($("#fileInput")[0].files.length == 0) {
					alert("이미지를 선택하세요.");
					return;
				}
				if(loginId == "") {
					alert("아이디를 입력해주세요.");
					return;
				}
				// 중복체크 여부 유효성 검사 
				if(!idOverlapCheck) {
					alert("중복여부 체크를 진행해주세요");
					return ;
				}
				// 아이디 중복여부 유효성 검사 
				if(idOverlapId) {
					alert("중복된 아이디입니다");
					return ;
				}
				if(password == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(confrimPassword == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				// 중복체크 여부 유효성 검사 
				if(!pwOverlapCheck) {
					alert("중복여부 체크를 진행해주세요");
					return ;
				}
				// 아이디 중복여부 유효성 검사 
				if(pwOverlapId) {
					alert("비밀번호가 일치하지 않습니다.");
					return ;
				}
				if(name == "") {
					alert("이름을 입력해주세요.");
					return;
				}
				if(nickName == "") {
					alert("닉네임을 입력해주세요.");
					return;
				}
				if(phoneNum == "") {
					alert("연락처를 입력해주세요.");
					return;
				}
				if(birth == "") {
					alert("주민등록번호 앞자리를 입력해주세요.");
					return;
				}
				if($("input[name=genderSelect]:radio:checked").length < 1) {
					alert("성별을 선택해주세요.");
					return;
				}
				if(exerciseSelect.value == "none") {
					alert("운동종목을 선택해주세요.");
					return;
				}
				if(regionSelect.value == "none") {
					alert("지역을 선택해주세요.");
					return;
				}
				if(email == "") {
					alert("이메일을 입력해주세요.");
					return;
				}
				
				var formData = new FormData();
				formData.append("profileImage", $("#fileInput")[0].files[0]);
				formData.append("loginId", loginId);
				formData.append("password", password);
				formData.append("name", name);
				formData.append("nickName", nickName);
				formData.append("phoneNum", phoneNum);
				formData.append("birth", birth);
				formData.append("gender", gender);
				formData.append("exercise", exercise);
				formData.append("region", region);
				formData.append("content", content);
				formData.append("email", email);
				
				$.ajax({
					type:"post",
					url:"/user/signup",
					data:formData,
					enctype:"multipart/form-data",
					processData:false,
					contentType:false,
					
					success:function(data) {
						if(data.result == "success") {
							location.href="/sportmate/user/signin/view";
						} else {
							alert("회원가입 실패");
						}
					},
					error:function() {
						alert("에러 발생");
					}
				});
				
				
			});
			
			
		});
	
	</script>
</body>
</html>