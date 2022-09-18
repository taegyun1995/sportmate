package com.project.sportmate.main.team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.sportmate.main.profile.bo.ProfileBO;
import com.project.sportmate.main.profile.model.StoryDetail;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.plan.bo.PlanBO;
import com.project.sportmate.main.team.plan.model.Plan;
import com.project.sportmate.main.team.plan.model.PlanDetail;
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
	@Autowired
	private ProfileBO profileBO;
	
	@GetMapping("/sportmate/team/detail/view")
	public String teamView(Model model
			, HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<TeamDetail> teamList = teamBO.getTeamList(userId);
		model.addAttribute("teamlist", teamList);

		List<PlanDetail> planDetailList = planBO.getPlanDetailList(userId);
		model.addAttribute("planDetailList", planDetailList);

		List<StoryDetail> storyTeamList = profileBO.getTeamStoryList();
		model.addAttribute("storyTeamList", storyTeamList);

		return "/team/detail";
	}
	
	@GetMapping("/sportmate/team/create/view")
	public String teamcreate() {
		
		return "/team/create";
	}
	
	
}
