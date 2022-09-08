package com.project.sportmate.main.team;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportmate.main.team.bo.TeamBO;

@RestController
public class TeamRestController {
	
	@Autowired
	private TeamBO teamBO;
	
	// 팀 생성
	@GetMapping("/team/make")
	public Map<String, String> createTeam(
			HttpServletRequest request
			, @RequestParam("teamname") String teamname
			, @RequestParam("exercise") String exercise
			, @RequestParam("region") String region
			, @RequestParam("content") String content) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> map = new HashMap<>();
		
		int count = teamBO.createTeam(userId, teamname, exercise, region, content);
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "success");
		}
		
		return map;
	}
	
	

}
