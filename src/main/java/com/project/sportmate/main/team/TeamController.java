package com.project.sportmate.main.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.model.TeamDetail;

@Controller
public class TeamController {
	
	@Autowired
	private TeamBO teamBO;
	
	@GetMapping("/sportmate/team/detail/view")
	public String teamView(Model model
			, HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<TeamDetail> teamList = teamBO.getTeamList(userId);
		model.addAttribute("teamlist", teamList);
		
		return "/team/detail";
	}
	
	@GetMapping("/sportmate/team/create/view")
	public String teamcreate() {
		
		return "/team/create";
	}
	
	
}
