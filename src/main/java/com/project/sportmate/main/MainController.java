package com.project.sportmate.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/sportmate/main/home/view")
	public String mainHome() {
		
		return "/main/home";
	}
	


}
