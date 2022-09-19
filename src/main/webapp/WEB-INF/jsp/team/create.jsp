<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 만들기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div class="bg-dark d-flex justify-content-center p-5">
		<div class="bg-white col-6">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			
			<hr>
			
			<section>
				<h4 class="text-center">Sportmate Team Making</h4>
				
					<div class="d-flex justify-content-center py-2">
						<div class="teamBox">
							
							<label class="signupLabel pt-2"> 팀명 </label>
							<input id="teamNameInput"  class="signupInput form-control" type="text" placeholder="팀명을 입력하세요."/>
							
							<label class="signupLabel pt-2"> 운동종목 </label>
							<select id="exerciseSelect" class="signupInput form-control" name="exerciseSelect">
								<option value="none"> 선택하시오. </option>
								<option value="축구"> 축구 </option>
								<option value="농구"> 농구 </option>
								<option value="헬스"> 헬스 </option>
							</select>
							
							<label class="signupLabel pt-2"> 지역 </label>
							<select id="regionSelect" class="signupInput form-control" name="regionSelect">
								<option value="none"> 선택하시오. </option>
								<option value="서울"> 서울 </option>
								<option value="경기"> 경기 </option>
								<option value="부산"> 부산 </option>
							</select>
							
							<label class="signupLabel pt-2"> 자기소개 </label>
							<textarea class="form-control" rows="3" id="contentInput"> </textarea>
							
						</div>
					</div>
				
				<div class="d-flex justify-content-end pt-2">
					<div class="d-flex justify-content-center">
						<button id="makeBtn" type="button"> 생성 </button>
						 <a href="/sportmate/team/detail/view"> <button id="cancelBtn" class="col-12 ml-1" type="button"> 취소 </button></a>
					</div>
				</div>
				
				
			</section>
		
			<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		</div>
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#makeBtn").on("click", function(){
				
				let teamname = $("#teamNameInput").val();
				let exercise = $("#exerciseSelect").val();
				let region = $("#regionSelect").val();
				let content = $("#contentInput").val();
				
				if(teamname == "") {
					alert("팀이름을 입력해주세요.");
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
				
				$.ajax({
					type:"get",
					url:"/team/make",
					data:{"teamname":teamname, "exercise":exercise, "region":region, "content":content},
					
					success:function(data) {
						if(data.result == "success") {
							location.href="/sportmate/team/detail/view";
						} else {
							alert("팀 생성 실패");
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