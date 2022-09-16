package com.project.sportmate.main.profile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.sportmate.main.profile.bo.ProfileBO;
import com.project.sportmate.main.profile.model.StoryDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileBO profileBO;
	
	@Autowired
	private UserBO userBO;
	
	// 프로필 화면
	@GetMapping("/sportmate/profile/detail/view")
	public String profileView(Model model
			, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<StoryDetail> storyDetailList = profileBO.getStoryList(userId);
		User user = userBO.getUserById(userId);
		
		model.addAttribute("storylist", storyDetailList);
		model.addAttribute("userlist", user);
		
		return "/profile/detail";
	}
	
	// 유저(프로필) 변경
	@GetMapping("/sportmate/profile/edit/view")
	public String profileEditView(Model model
			, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		User user = userBO.getUserById(userId);
		
		model.addAttribute("userlist", user);
		
		return "/profile/profileEdit";
	}
	
	// 스토리 작성화면
	@GetMapping("/sportmate/profile/story/create/view")
	public String storycreateView() {


		return "/profile/storycreate";
	}
	

}
