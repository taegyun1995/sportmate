package com.project.sportmate.main.team.bo;

import com.project.sportmate.main.profile.dao.ProfileDAO;
import com.project.sportmate.main.team.dao.TeamDAO;
import com.project.sportmate.main.team.member.bo.MemberBO;
import com.project.sportmate.main.team.member.model.Member;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.model.TeamDetail;
import com.project.sportmate.main.team.plan.bo.PlanBO;
import com.project.sportmate.main.team.plan.model.Plan;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
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
    private UserBO userBO;

    public int createTeam(Team team) {
        int count = teamDAO.addTeam(team);

        if (count == 1) {
            Member member = new Member();
            member.setUserId(team.getUserId());
            member.setTeamId(team.getId());

            memberBO.createMember(member);
        }

        return count;
    }

    public List<Team> getTeamListById(List<Integer> teamIdList) {

        if (teamIdList.isEmpty()) {
            return Collections.emptyList();
        }

        return teamDAO.selectTeamListById(teamIdList);
    }

    public List<TeamDetail> getAwesomeTeamListByUserId(int userId) {
        List<Member> memberListByUserId = memberBO.selectMemberListByUserId(userId);

        List<Integer> teamIdList = new ArrayList();

        for (Member member : memberListByUserId) {
            teamIdList.add(member.getTeamId());
        }

        return this.getTeamListByIdList(teamIdList);
    }

    public List<TeamDetail> getTeamListByIdList(List<Integer> teamIdList) {

        List<TeamDetail> teamDetailList = new ArrayList<>();
        List<Team> teamList = teamDAO.selectTeamListById(teamIdList);

        // FIXME: team - member - user join 해야함. N+1 problem
        for (Team team : teamList) {
            int team_id = team.getId();
            Member member = memberBO.selectMemberByTeamId(team_id);
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

    public Team getTeamById(int id) {

        return teamDAO.selectTeamById(id);
    }


}
