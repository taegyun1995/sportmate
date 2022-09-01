package com.project.sportmate.main.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.sportmate.main.profile.bo.ProfileBO;
import com.project.sportmate.main.profile.model.Story;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileBO profileBO;
	
	// 유저(프로필) 변경
	@GetMapping("/sportmate/profile/edit/view")
	public String profileEditView() {
		
		return "/profile/profileEdit";
	}
	
	// 프로필 화면
	@GetMapping("/sportmate/profile/detail/view")
	public String profileView(
			@RequestParam("userId") int userId
			, Model model) {
		
		List<Story> storyList = profileBO.getStoryList(userId);
		model.addAttribute("storylist", storyList);
		
		return "/profile/detail";
	}
	
	// 스토리 작성화면
	@GetMapping("/sportmate/profile/story/create/view")
	public String storycreateView() {
		
		return "/profile/storycreate";
	}
	

}
