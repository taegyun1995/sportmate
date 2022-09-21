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
        </div>

       <h4 class="pt-5 pb-4"> Sportmate Hunting Member </h4>

    <section>
        <c:forEach var="DetailHunt" items="${huntList}">
            <div> ${DetailHunt.hunt.title} </div>
            <div class="d-flex bg-success">
                <div class="bg-warning col-3">
                    <label class="signupLabel pt-2"> 팀명 </label>
                    <input class="signupInput form-control" placeholder="팀명을 입력하세요." readonly/>

                    <label class="signupLabel pt-2"> 종목 </label>
                    <input class="signupInput form-control" placeholder="팀명을 입력하세요." readonly/>

                    <label class="signupLabel pt-2"> 지역 </label>
                    <input class="signupInput form-control" placeholder="제목을 입력하세요." readonly/>
                </div>
                <div clas="bg-danger col-9"> gg </div>
            </div>
        </c:forEach>
    </section>

    <c:import url="/WEB-INF/jsp/include/footer.jsp" />

    </div>

</body>
</html>