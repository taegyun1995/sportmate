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
                                        <td class="col-1"> <small> ${DetailHunt.team.teamname} </small> </td>
                                        <td class=""> <small> ${DetailHunt.hunt.title} </small> </td>
                                        <td class="col-1"> <small> ${DetailHunt.team.exercise} </small> </td>
                                        <td class="col-1"> <small> ${DetailHunt.team.region} </small> </td>
                                        <td class="col-1">
                                            <button type="button" id="supportBtn" class="btn btn-sm" data-toggle="modal" data-target="#moreModal" data-hunt-id="${DetailHunt.hunt.id}">
                                                ${DetailHunt.hunt.state}
                                            </button>
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

        <!-- Modal -->
        <div class="modal fade" id="moreModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                     <div class="modal-body text-center">
                         <button id="applicantBtn" class="btn btn-primary btn-sm" type="button">지원하시겠습니까?</button>
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

            $(".more-btn").on("click", function(){
                let huntId = $(this).data("hunt-id");

                $("#applicantBtn").data("hunt-id", huntId);
            });

            $("#applicantBtn").on("click", function(e) {
                e.preventDefault();

                  let huntId = $(this).data("hunt-id");

                  $.ajax({
                      type:"get",
                      url:"/hunt/update",
                      data:{"huntId":huntId},
                      success:function(data) {
                          if(data.result == "success") {
                              location.reload();
                          } else {
                              alert("지원 실패");
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