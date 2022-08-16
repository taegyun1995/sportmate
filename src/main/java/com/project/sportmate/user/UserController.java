package com.project.sportmate.user;

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

}
