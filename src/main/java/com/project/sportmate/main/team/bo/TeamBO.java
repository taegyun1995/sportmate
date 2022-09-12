package com.project.sportmate.main.team.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.main.team.dao.TeamDAO;
import com.project.sportmate.main.team.member.bo.MemberBO;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.model.TeamDetail;

@Service
public class TeamBO {
	
	@Autowired
	private TeamDAO teamDAO;
	
	@Autowired
	private MemberBO memberBO;

	public int createTeam(int userId, String teamname, String exercise, String region, String content) {
		
		int count = teamDAO.addTeam(userId, teamname, exercise, region, content);
		
		if(count == 1) {
			memberBO.createMember(userId, content);
		}
		
		return count;
	}
	
	public List<TeamDetail> getTeamList(int userId) {
		
		List<TeamDetail> teamDetailList = new ArrayList<>();
		List<Team> teamlist = teamDAO.selectTeamList(userId);
		
		for(Team team : teamlist) {
			
			TeamDetail teamDetail = new TeamDetail();
			teamDetail.setTeam(team);
			
			teamDetailList.add(teamDetail);
		}
		
		return teamDetailList;
	}
	
	
	
	
}
