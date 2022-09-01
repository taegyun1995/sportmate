<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토리 작성</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div class="bg-dark p-5">
		<div id="wrap2" class="bg-white col-6">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			
			<hr>
			
			<section>
				<div class="d-flex justify-content-center py-3">
					<img id="preview-image2" src="/static/img/photo.png" width="100%" height="350"/>
				</div>
				
				<textarea class="form-control" rows="5" id="contentInput"> </textarea>
		
				<div class="d-flex justify-content-between pt-2">
					<div class="d-flex align-items-center">
						<a href="#" id="imageIcon" class="d-flex align-items-center text-dark"> <img width="15" src="/static/img/photo.png"/> 사진 첨부 </a>
						<input type="file" class="btn d-none" id="fileInput">
					</div> 
					
					<div class="d-flex justify-content-center">
						<button id="uploadBtn" class="" type="button"> 업로드 </button>
						 <a href="/sportmate/profile/detail/view?userId=${userId }"> <button id="cancelBtn" class="col-12 ml-1" type="button"> 취소 </button></a>
					</div>
				</div>
				
				
			</section>
		
			<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		</div>
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
		            const previewImage2 = document.getElementById("preview-image2")
		            previewImage2.src = e.target.result
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
		
		$("#uploadBtn").on("click", function(e) {
			e.preventDefault(); // 이벤트 안 고유의 기능을 제거 
			
			let content = $("#contentInput").val();
			
			if($("#fileInput")[0].files.length == 0) {
				alert("이미지를 선택하세요.");
				return;
			}
			if(content == "") {
				alert("내용을 입력해주세요.");
				return;
			}
			
			var formData = new FormData();
			formData.append("storyImage", $("#fileInput")[0].files[0]);
			formData.append("content", content);
			
			$.ajax({
				type:"post",
				url:"/story/create",
				data:formData,
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				
				success:function(data) {
					if(data.result == "success") {
						location.href="/sportmate/profile/detail/view?userId=" + ${userId};
					} else {
						alert("스토리 작성 실패");
					}
				},
				error:function() {
					alert("에러 발생");
				}
			});
			
		});
		
		
	</script>
</body>
</html>