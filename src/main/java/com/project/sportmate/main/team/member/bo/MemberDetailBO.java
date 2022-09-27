package com.project.sportmate.main.team.member.bo;

import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.member.dao.MemberDAO;
import com.project.sportmate.main.team.member.model.Member;
import com.project.sportmate.main.team.member.model.MemberDetail;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.model.TeamDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberDetailBO {

    @Autowired
    private MemberBO memberBO;
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private UserBO userBO;
    @Autowired
    private TeamBO teamBO;

    public List<MemberDetail> getAwesomeTeamMemberListByUserId(int userId) {
        List<Member> memberListByUserId = memberBO.getMemberListByUserId(userId);

        List<Integer> teamIdList = new ArrayList();

        for (Member member : memberListByUserId) {
            teamIdList.add(member.getTeamId());
        }

        return this.getTeamMemberListByIdList(teamIdList);
    }

    public List<MemberDetail> getTeamMemberListByIdList(List<Integer> teamIdList) {

        List<MemberDetail> memberDetailList = new ArrayList<>();
        List<Member> memberList = memberDAO.selectTeamMemberListById(teamIdList);

        for (Member member : memberList) {
            User user = userBO.getUserById(member.getUserId());
            Team team = teamBO.getTeamById(member.getTeamId());

            MemberDetail memberDetail = new MemberDetail();
            memberDetail.setMember(member);
            memberDetail.setUser(user);
            memberDetail.setTeam(team);
            memberDetailList.add(memberDetail);
        }

        return memberDetailList;
    }
}
