<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="py-3">
			<div class="d-flex justify-content-center">
				<div class="col-4">
					<h2 class="text-center"> Profile Edit </h2>
					
					<div class="d-flex justify-content-center py-2">
						<img id="preview-image" src="${userProfileImage }" width="200" height="200"/>
					</div>
					
					
					<div class="d-flex justify-content-center">
						<div class="d-flex align-items-center">
							<a href="#" id="imageIcon" class="d-flex align-items-center text-dark"> <img width="15" src="/static/img/photo.png"/> Profile Photo Change </a>
							<input type="file" class="btn d-none" id="fileInput">
						</div>
					</div>
					
					<label class="signupLabel pt-4"> 아이디 </label>
					<input id="loginIdInput" class="signupInput form-control border-none" type="text" placeholder="${userLoginId }" readonly />
									
					<label class="signupLabel pt-4"> 닉네임 </label>
					<input id="nickNameInput"  class="signupInput form-control" type="text" placeholder="${userNickName }"/>
					
					<label class="signupLabel pt-4"> 운동종목 </label>
					<select id="exerciseInput" class="signupInput form-control">
						<option value=""> ${userExercise } </option>
						<option value="축구"> 축구 </option>
						<option value="농구"> 농구 </option>
						<option value="헬스"> 헬스 </option>
					</select>
					
					<label class="signupLabel pt-4"> 지역 </label>
					<select id="regionSelect" class="signupInput form-control" name="regionSelect">
						<option value="${userRegion }"> ${userRegion } </option>
						<option value="서울"> 서울 </option>
						<option value="경기"> 경기 </option>
						<option value="부산"> 부산 </option>
					</select>
					
					<label class="signupLabel pt-4"> 자기소개 </label>
					<textarea class="form-control" rows="3" id="contentInput"> </textarea>
					
					<div class="d-flex justify-content-center py-3">
						<button id="editSaveBtn" type="button"> 저장 </button>
					</div>
					
				</div>
			</div>
		
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
	
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
		
		$("#editSaveBtn").on("click", function(e) {
			e.preventDefault();
			
			let loginId = $("#loginIdInput").val();
			let nickName = $("#nickNameInput").val();
			let exercise = $("#exerciseSelect").val();
			let region = $("#regionSelect").val();
			let content = $("#contentInput").val();
			
			var formData = new FormData();
			formData.append("profileImage", $("#fileInput")[0].files[0]);
			formData.append("loginId", loginId)
			formData.append("nickName", nickName);
			formData.append("exercise", exercise);
			formData.append("region", region);
			formData.append("content", content);
			
			$.ajax({
				type:"post",
				url:"/profile/edit",
				data:formData,
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				
				success:function(data) {
					if(data.result == "success") {
						location.href="/sportmate/profile/detail/view";
					} else {
						alert("프로필 편집 실패");
					}
				},
				error:function() {
					alert("에러 발생!!");
				}
				
			});
		});
	
	</script>
</body>
</html>