<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 화면</title>
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
		
		<h3 class="py-2"> Team </h3>	
		
		<section>
		    <form>
                <div class="px-5">

                    <div class="border-bottom">
                        <h5> My Team </h5>
				    </div>
				
                    <div class="d-flex">
                        <div class="teambox border rounded m-2">
                            <div class="pl-2 pt-1">
                                <a href="/sportmate/team/create/view" class="text-info">
                                    <span class="d-flex align-items-center pl-1"> <i class="bi bi-plus-circle"> </i> </span>
                                </a>
                            </div>
                        </div>
                        <c:forEach var="DetailTeam" items="${teamlist}" varStatus="status">
                            <div class="teambox border rounded m-2">
                                <div class="p-2"> 팀명 <b> ${DetailTeam.team.teamname } </b> </div>
                                <div class="pl-2 pt-1"> 대표 ${DetailTeam.user.name} </div>
                                <div class="pl-2 pt-1"> 인원  </div>
                                <div class="pl-2 pt-1"> ${DetailTeam.team.region }  </div>
                            </div>
                        </c:forEach>
                    </div>
				
                    <div class="border-bottom">
                        <h5 class="pt-3"> My Team Plan </h5>
                    </div>
				
                    <div class="pt-2">
                        <div id="signupInput" class="d-flex">
                            <select id="teamnameSelect" class="form-control col-1">
                                <c:forEach var="DetailTeam" items="${teamlist}" varStatus="status">
                                    <option value=${DetailTeam.team.id} id="teamIdInput"> ${DetailTeam.team.teamname } </option>
                                </c:forEach>
                            </select>
                            <input id="planInput"  class="signupInput form-control ml-1 mt-2" type="text" placeholder="계획을 입력하세요."/>
                            <button id="planCreateBtn" class="col-2 ml-1 mt-2" type="button"> 작성 </button>
                        </div>

                        <table class="table" height="20">
                            <thead>
                                <tr>
                                    <th class="col-1"> <small> <b> 팀명 </b> </small> </th>
                                    <th class="col-9"> <small> <b> 계획 </b> </small> </th>
                                    <th> <small> <b> 작성날짜 </b> </small> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="DetailPlan" items="${planDetailList}">
                                    <tr>
                                        <td> <small> <b> ${DetailPlan.team.teamname } </b> </small> </td>
                                        <td> <small> ${DetailPlan.plan.plan } </small> </td>
                                        <td> <small> <fmt:formatDate value="${DetailPlan.plan.createdAt }" pattern="YY-MM-dd hh:mm" /> </small> </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="d-flex justify-content-start">
                        <div class="teamStory">
                            <div class="border-bottom">
                                <h5 class="pt-3"> My Team Story </h5>
                            </div>

                            <c:forEach var="DetailStory" items="${storyTeamList}">
                                <div class="my-2 border">
                                    <img class="p-2" src="${DetailStory.story.storyImage}" width="100%" height="400") />
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
                                            <i class="bi bi-three-dots-vertical text-dark"></i>
                                        </a>
                                    </div>
                                </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            <form>
		</section>

		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

	<script>

	    $(document).ready(function() {

            $("#planCreateBtn").on("click", function() {

                let plan = $("#planInput").val();
                let teamname = $("#teamnameSelect").val();

                if(plan == "") {
                    alert("계획을 입력해주세요.");
                    return;
                }

                $.ajax({
                    type:"post",
                    url:"/team/plans/create",
                    data:{"teamId":teamname, "plan":plan},

                    success:function(data) {
                        if(data.result == "success") {
                            location.reload();
                        } else {
                            alert("계획 작성 실패");
                        }
                    },
                    error:function() {
                        alert("에러 발생");
                    }

                });

            });
	    });

	</script
</body>
</html>