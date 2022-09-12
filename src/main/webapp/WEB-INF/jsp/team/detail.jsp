<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<div class="pl-2 pt-1"> 대표  </div>
							<div class="pl-2 pt-1"> 인원  </div>
							<div class="pl-2 pt-1"> ${DetailTeam.team.region }  </div>
						</div>
					</c:forEach>
				</div>
				
				<div class="border-bottom">
					<h5 class="pt-3"> My Team Plan </h5>
				</div>
				
				<div class="pt-2">
					<div class="d-flex">
						<input id="nameInput"  class="signupInput form-control" type="text" placeholder="계획을 입력하세요."/>
						<button id="pwoverLapBtn" class="col-2 ml-1" type="button"> 작성 </button>
					</div>
					<ul class="pl-4 pt-2">
                        <c:forEach var="DetailPlan" items="${planList}">
                            <li> <b> ${DetailPlan.teamId } </b> ${DetailPlan.plan }. ${DetailPlan.createdAt } </li>
                        </c:forEach>
                    </ul>
				</div>
				
								
				<div class="border-bottom">
					<h5 class="pt-3"> My Team Story </h5>
				</div>
				
				gg
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>
</html>