package com.project.sportmate.main.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.sportmate.main.team.plan.bo.PlanBO;
import com.project.sportmate.main.team.plan.model.Plan;
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

	@Autowired
	private PlanBO planBO;
	
	@GetMapping("/sportmate/team/detail/view")
	public String teamView(Model model
			, HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<TeamDetail> teamList = teamBO.getTeamList(userId);
		model.addAttribute("teamlist", teamList);

		List<Plan> planList = planBO.getPlanList(userId);
		model.addAttribute("planList", planList);
		
		return "/team/detail";
	}
	
	@GetMapping("/sportmate/team/create/view")
	public String teamcreate() {
		
		return "/team/create";
	}
	
	
}
