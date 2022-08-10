package com.project.sportmate.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/sportmate/user/signup/view")
	public String signup() {
		
		return "/user/signup";
	}

}
