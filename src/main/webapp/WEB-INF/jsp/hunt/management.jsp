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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>

    <div id="wrap">
        <div class="d-flex">
            <c:import url="/WEB-INF/jsp/include/header.jsp" />
        </div>

       <h4 class="pt-5 pb-4"> Sportmate Hunting Member </h4>

    <section>
        <div class="pl-2"> <b> ${huntList.hunt.title} </b> </div>
        <div class="d-flex">
            <div class="col-3 ml-2 mr-4">
                <label class="signupLabel pt-3"> 팀명 </label>
                <input class="signupInput form-control" placeholder="${huntList.team.teamname}" readonly/>

                <label class="signupLabel pt-2"> 종목 </label>
                <input class="signupInput form-control" placeholder="${huntList.team.exercise}" readonly/>

                <label class="signupLabel pt-2"> 지역 </label>
                <input class="signupInput form-control" placeholder="${huntList.team.region}" readonly/>
            </div>
            <div clas="col-9">
                <div class="d-flex">
                    <c:forEach var="applicantMember" items="${huntList.applicants}">
                        <div class="border rounded ml-3 mb-3">
                            <div class="d-flex">
                                <div class="p-1"> <img src="${applicantMember.user.profileImage}" width="130" height="130" class="p-2"/> </div>
                                <div class="p-1">
                                    <a href="#">
                                        <i class="bi bi-three-dots text-dark"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between">
                                <div class="d-flex">
                                    <div class="pl-1">
                                        <a href="#" class="like-btn" data-story-id="${DetailStory.story.id}">
                                            <span class="heart-size"> <i class="bi bi-heart"> </i> </span>
                                        </a>
                                    </div>
                                    <div> <small> 5 </small> </div>
                                </div>
                                <div class="d-flex">
                                    <div> <small> ${applicantMember.user.name} </small> </div>
                                    <div class="px-1"> <small> ${applicantMember.user.birth} </small> </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>

    <c:import url="/WEB-INF/jsp/include/footer.jsp" />

    </div>

</body>
</html>