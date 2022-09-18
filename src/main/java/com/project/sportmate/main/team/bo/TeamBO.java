package com.project.sportmate.main.team.bo;

import com.project.sportmate.main.profile.dao.ProfileDAO;
import com.project.sportmate.main.team.dao.TeamDAO;
import com.project.sportmate.main.team.member.bo.MemberBO;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.model.TeamDetail;
import com.project.sportmate.user.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamBO {
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private MemberBO memberBO;
    @Autowired
    private ProfileDAO profileDAO;
    @Autowired
    private UserBO userBO;

    public int createTeam(Team team) {

        int teamId = teamDAO.addTeam(team);
        System.out.println(">>>>>>>>>>>  , ${teamId}" + teamId + " " + team.getId());

        return 1;
    }

    public List<Team> getTeamListById(List<Integer> teamIdList) {

        if(teamIdList.isEmpty()) {
            return Collections.emptyList();
        }

        return teamDAO.selectTeamListById(teamIdList);
    }

    public List<TeamDetail> getTeamList(int userId) {

        List<TeamDetail> teamDetailList = new ArrayList<>();
        List<Team> teamlist = teamDAO.selectTeamList(userId);

        for (Team team : teamlist) {

            TeamDetail teamDetail = new TeamDetail();
            teamDetail.setTeam(team);

            teamDetailList.add(teamDetail);
        }

        return teamDetailList;
    }


}
