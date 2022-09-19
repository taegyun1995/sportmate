package com.project.sportmate.main.team;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.sportmate.main.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			, @ModelAttribute Team team) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		team.setUserId(userId);

		Map<String, String> map = new HashMap<>();
		int count = teamBO.createTeam(team);

		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "success");
		}
		
		return map;
	}
	
	

}
