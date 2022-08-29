<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<nav class="d-flex justify-content-end align-items-center">
		<c:choose>
			<c:when test="${not empty userId}" >
				<div class="mr-3"> ${userName }님 <a href="/user/sign/out"> 로그아웃 </a> </div>
			</c:when>
			<c:otherwise>
				<div class="mr-3"> <a href="/sportmate/user/signin/view"> 로그인 </a></div>
			</c:otherwise>
		</c:choose>
	</nav>