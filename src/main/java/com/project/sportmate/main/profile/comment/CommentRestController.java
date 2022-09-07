package com.project.sportmate.main.profile.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportmate.main.profile.comment.bo.CommentBO;

@RestController
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO;
	
	// 댓글 작성
	@PostMapping("/story/comment/create")
	public Map<String, String> createComment(
			HttpServletRequest request
			, @RequestParam("storyId") int storyId
			, @RequestParam(value="comment", required=false) String comment) {
		
		Map<String, String> map = new HashMap<>();
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = commentBO.createComment(userId, storyId, comment);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
}