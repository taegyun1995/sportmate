package com.project.sportmate.main.profile.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportmate.main.profile.like.bo.LikeBO;

@RestController
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	// 좋아요
	@GetMapping("/story/like/insert")
	public Map<String, String> like(
			HttpServletRequest request
			, @RequestParam("storyId") int storyId) {

		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> map = new HashMap<>();
		int count = likeBO.addLike(userId, storyId);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	// 좋아요 취소
	@GetMapping("/story/like/delete")
	public Map<String, String> unlike(
			HttpServletRequest request
			, @RequestParam("storyId") int storyId) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> map = new HashMap<>();
		
		int count = likeBO.deleteLike(storyId, userId);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
}
