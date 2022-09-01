package com.project.sportmate.main.profile;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.sportmate.main.profile.bo.ProfileBO;

@RestController
public class ProfileRestController {
	
	@Autowired
	private ProfileBO profileBO;
	
	// 스토리 작성
	@PostMapping("/story/create")
	public Map<String, String> insertStory(
			HttpServletRequest request
			, @RequestParam(value="storyImage", required=false) MultipartFile storyImage
			, @RequestParam("content") String content) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> map = new HashMap<>();
		
		int count = profileBO.addStory(userId, storyImage, content);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
}
