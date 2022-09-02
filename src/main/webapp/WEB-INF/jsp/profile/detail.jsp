<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<div class="d-flex">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		</div>
		
		<section class="py-3">
			<div class="d-flex">
				<c:if test="${not empty userId}" >
					<div class="col-3 mx-2">
					
						<div class="d-flex justify-content-center pt-3">
							<img id="preview-image" src="${userProfileImage}" width="200" height="200"/>
						</div>
						
						<div class="d-flex justify-content-end mx-2 pt-3">
							<div>${userName}(<b>${userNickName }</b>) </div>
						</div>
						
						<hr>
						
						<div class="profilecontent border rounded">
							<div class="p-2"> ${userContent} </div>
 						</div>
						
						<div class="d-flex">
							<a href="/sportmate/profile/edit/view"> <button id="editBtn" class="my-3" type="button"> 프로필 편집 </button> </a>
						</div>
						
					</div>
				</c:if>
				
				<div class="col-7 mx-4">
					<div>
						<div class="teammemberBox border-bottom">
							<div class="teammember py-1"> Team Member </div>
							<div class="profileImg2">
								<div class="profileImg2"> <img src="#" /> </div>
								<div class="d-flex justify-content-center"> <small> name </small> </div>
							</div>
						</div>
					</div>
					
					<br>
					
					<div>
						<div class="d-flex pb-2">
							<div class="d-flex align-items-center  teammember ">Story</div>
							<a href="/sportmate/profile/story/create/view" class="text-info"> <span class="d-flex align-items-center pl-1"> <i class="bi bi-plus-circle"> </i> </span> </a>
						</div>
						<c:forEach var="DetailStory" items="${storylist }" varStatus="status">
							<div class="my-2 border">
								<img class="p-2" src="${DetailStory.story.storyImage}" width="100%" height="400" />
								<div class="d-flex justify-content-between border-top pb-1">
									<div class="d-flex p-1">
										<c:choose>
											<c:when test="${DetailStory.like}" >
												<a href="#" class="unlike-btn" data-story-id="${DetailStory.story.id}">
													<span class="heart-size text-dark"> <i class="bi bi-heart-fill"> </i> </span>
												</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="like-btn" data-story-id="${DetailStory.story.id}">
													<span class="heart-size"> <i class="bi bi-heart"> </i> </span>
												</a>
											</c:otherwise>
										</c:choose>
										<div class="ml-1"> 좋아요 ${DetailStory.likeCount } 개</div>
									</div>
									<div class="d-flex align-items-center">
										<a href="#"  data-toggle="modal" data-target="#moreModal" class="more-btn" data-story-id="${DetailStory.story.id}">
											<i class="bi bi-trash"></i>
										</a>
									</div>
								</div>
								<div class="d-flex border-bottom p-1">
									<div> ${DetailStory.story.content }</div>
								</div>
								<div>
									<div> <small> 댓글 </small> </div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
		<!-- Modal -->
		<div class="modal fade" id="moreModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		 	<div class="modal-dialog modal-dialog-centered" role="document">
		    	<div class="modal-content">
		      
				     <div class="modal-body text-center">
				    	 <button id="deleteBtn" class="btn btn-primary btn-sm" type="button">삭제하기</button>
				     </div>
			      
			     	 <div class="modal-footer">
			        	<button id="modalcancelBtn" class="btn btn-primary btn-sm" type="button" data-dismiss="modal">취소</button>
			      	</div>
		      	</div>
			</div>
		</div>
		
	</div>
	
	<script>
		$(document).ready(function(){
			
			$(".like-btn").on("click", function(e) {
				e.preventDefault();
				
				let storyId = $(this).data("story-id");
				
				$.ajax({
					type:"get",
					url:"/story/like/insert",
					data:{"storyId":storyId},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("좋아요 실패");
						}
					},
					error:function() {
						alert("좋아요 에러")
					}
				});
			});
			
			$(".unlike-btn").on("click", function(e){
				e.preventDefault();
				
				let storyId = $(this).data("story-id");
				
				$.ajax({
					type:"get",
					url:"/story/like/delete",
					data:{"storyId":storyId},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("좋아요 취소 실패..");
						}
					},
					error:function() {
						alert("좋아요 취소 에러!!");
					}
				});
				
			});
			
			$(".more-btn").on("click", function(){
				let storyId = $(this).data("story-id");
				
				$("#deleteBtn").data("story-id", storyId);
			});
			
			$("#deleteBtn").on("click", function(e) {
				e.preventDefault();
				
				let storyId = $(this).data("story-id");
				
				$.ajax({
					type:"get",
					url:"/story/delete",
					data:{"storyId":storyId},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("삭제 실패");
						}
					},
					error:function() {
						alert("삭제 에러");
					}
				});
				
			});
			
			
			
		});
	
	</script>
	
</body>
</html>