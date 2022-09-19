<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<nav class="d-flex justify-content-end align-items-center">
		<ul class="nav nav-fill">
			<li class="nav-item px-2 mx-1"> <a href="/sportmate/main/home/view" id="homeBtn" class="nav-link small-link h-100"> Home </a> </li>
			<li class="nav-item px-2"><a href="/sportmate/profile/detail/view?userId=${userId }" id="profileBtn" class="nav-link small-link h-100">profile</a></li>
			<li class="nav-item px-2"><a href="/sportmate/team/detail/view" id="teamBtn" class="nav-link small-link h-100">Team</a></li>
			<li class="nav-item pl-2 pr-5"><a href="/sportmate/hunt/detail/view" id="huntBtn" class="nav-link small-link h-100">Hunt</a></li>
			
			<li class="nav-item d-flex align-items-center">
				<c:choose>
					<c:when test="${not empty userId}" >
						<div class="mr-3"> ${userLoginId }님 <a href="/user/sign/out" > 로그아웃 </a> </div>
					</c:when>
					<c:otherwise>
						<div class="mr-3"> <a href="/sportmate/user/signin/view" class="nav-link small-link"> 로그인 </a></div>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
	</nav>