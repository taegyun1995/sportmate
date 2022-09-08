package com.project.sportmate.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");

		String uri = request.getRequestURI();
		
		if(userId != null) {
			if(uri.startsWith("/sportmate/user")) {
				response.sendRedirect("/sportmate/main/home/view");
				return false;
			}
		} else { 
			if(uri.startsWith("/sportmate/main") || uri.startsWith("/sportmate/profile") || uri.startsWith("/sportmate/team")) {
				response.sendRedirect("/sportmate/user/signin/view");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, ModelAndView modelAndView) {
	}
	
	@Override
	public void afterCompletion(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception ex) {
		
	}

}
