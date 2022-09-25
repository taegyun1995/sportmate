<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hunt</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<div class="d-flex">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		</div>

        <h3 class="pt-2 pb-5"> Hunt </h3>

		<section>
		    <form>
		        <div class="px-5">

                    <div class="d-flex justify-content-between align-items-end borer-bottom">
                        <h4> hunting </h4>
                        <div> <a href="/sportmate/hunt/create/view"> hunt </a> </div>
                    </div>

                    <div>
                        <table class="table text-center">
                            <thead>
                                <tr>
                                    <th> 팀명 </th>
                                    <th> 제목 </th>
                                    <th> 운동 </th>
                                    <th> 지역 </th>
                                    <th> 지원 </th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="DetailHunt" items="${huntList}">
                                    <tr>
                                        <td class="col-1" data-team-id="${DetailHunt.team.id}"> <small> ${DetailHunt.team.teamname} </small> </td>
                                        <td> <small> ${DetailHunt.hunt.title} </small> </td>
                                        <td class="col-1"> <small> ${DetailHunt.team.exercise} </small> </td>
                                        <td class="col-1"> <small> ${DetailHunt.team.region} </small> </td>
                                        <td class="col-1">
                                            <c:choose>
                                                <c:when test="${DetailHunt.support}">
                                                    <button type="button" class="supportCancleBtn" class="btn btn-sm" data-hunt-id="${DetailHunt.hunt.id}">
                                                        대기
                                                    </button>
                                                </c:when>
                                                <c:when test="${DetailHunt.user.id eq userId}">
                                                    <a href="/sportmate/hunt/management/view?id=${DetailHunt.hunt.id}">
                                                        <button type="button" class="confirmBtn" class="btn btn-sm" data-hunt-id="${DetailHunt.hunt.id}">
                                                            확인
                                                        </button>
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    <button type="button" class="supportBtn" class="btn btn-sm" data-hunt-id="${DetailHunt.hunt.id}">
                                                        지원
                                                    </button>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="col-2"> <small> <fmt:formatDate value="${DetailHunt.hunt.createdAt }" pattern="YY-MM-dd hh:mm" />  </small> </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
		    </form>
		</section>

		<c:import url="/WEB-INF/jsp/include/footer.jsp" />

	</div>

	<script>

	    $(document).ready(function(){

 			$(".supportBtn").on("click", function(e) {
 				e.preventDefault();

 				let huntId = $(this).data("hunt-id");
                let teamName = $("#teamNameSelect").val();

 				$.ajax({
 					type:"get",
 					url:"/hunt/support",
 					data:{"teamId":teamName, "huntId":huntId},
 					success:function(data) {
 						if(data.result == "success") {
 							location.reload();
 						} else {
 							alert("지원 실패");
 						}
 					},
 					error:function() {
 						alert("에러 발생!")
 					}
 				});
 			});

            $(".supportCancleBtn").on("click", function(e){
                e.preventDefault();

                let huntId = $(this).data("hunt-id");

                $.ajax({
                    type:"get",
                    url:"/hunt/unSupport",
                    data:{"huntId":huntId},
                    success:function(data) {
                        if(data.result == "success") {
                            location.reload();
                        } else {
                            alert("헌팅 취소 실패..");
                        }
                    },
                    error:function() {
                        alert("에러!!");
                    }
                });

            });


	    });

	</script>

</body>
</html>