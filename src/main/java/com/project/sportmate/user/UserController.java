package com.project.sportmate.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	// 회원가입 View
	@GetMapping("/sportmate/user/signup/view")
	public String signup() {
		
		return "/user/signup";
	}
	
	// 로그인 화면 View
	@GetMapping("/sportmate/user/signin/view")
	public String signin() {
		
		return "/user/signin";
	}
	
	// 로그아웃
	@GetMapping("/user/sign/out")
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userBirth");
		
		return "redirect:/sportmate/user/signin/view";
	}
	
	// 아이디 찾기
	@GetMapping("/sportmate/user/find/id/view")
	public String loginIdFindView() {
		
		return "/user/findId";
	}
	
	// 비밀번호 변경
	@GetMapping("/sportmate/user/change/pw/view")
	public String passwordFindView() {
		
		return "/user/findPw";
	}
	
	
}
