package com.project.sportmate.main.team.bo;

import com.project.sportmate.main.profile.dao.ProfileDAO;
import com.project.sportmate.main.team.dao.TeamDAO;
import com.project.sportmate.main.team.member.bo.MemberBO;
import com.project.sportmate.main.team.member.model.Member;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.model.TeamDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
        int count = teamDAO.addTeam(team);

        if(count == 1) {
            Member member = new Member();
            member.setUserId(team.getUserId());
            member.setTeamId(team.getId());

            memberBO.createMember(member);
        }

        return count;
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


        // FIXME: team - member - user join 해야함. N+1 problem
        for (Team team : teamlist) {
            int teamId = team.getId();

            Member member = memberBO.selectMemberByTeamId(teamId);
            User user = userBO.getUserById(member.getUserId());
            int memberCount = memberBO.getCountMemberByTeamId(member);

            TeamDetail teamDetail = new TeamDetail();
            teamDetail.setTeam(team);
            teamDetail.setMember(member);
            teamDetail.setUser(user);
            teamDetail.setMemberCount(memberCount);
            teamDetailList.add(teamDetail);
        }

        return teamDetailList;
    }


}
