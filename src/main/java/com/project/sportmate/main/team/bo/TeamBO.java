package com.project.sportmate.main.team.bo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.project.sportmate.main.profile.comment.bo.CommentBO;
import com.project.sportmate.main.profile.comment.model.CommentDetail;
import com.project.sportmate.main.profile.dao.ProfileDAO;
import com.project.sportmate.main.profile.like.bo.LikeBO;
import com.project.sportmate.main.profile.model.Story;
import com.project.sportmate.main.profile.model.StoryDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
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
    @Autowired
    private ProfileDAO profileDAO;
    @Autowired
    private UserBO userBO;

    public int createTeam(int userId, String teamname, String exercise, String region, String content) {

        return teamDAO.addTeam(userId, teamname, exercise, region, content);
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
        List<Story> storyList = profileDAO.selectStoryList();

        for (Team team : teamlist) {

            TeamDetail teamDetail = new TeamDetail();
            teamDetail.setTeam(team);

            teamDetailList.add(teamDetail);
        }

        return teamDetailList;
    }


}
