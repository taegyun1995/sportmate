package com.project.sportmate.main.team.member.bo;

import com.project.sportmate.main.hunt.applicant.model.ApplicantDetail;
import com.project.sportmate.main.hunt.model.Hunt;
import com.project.sportmate.main.hunt.model.HuntDetail;
import com.project.sportmate.main.profile.model.StoryDetail;
import com.project.sportmate.main.team.member.model.Member;
import com.project.sportmate.main.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.main.team.member.dao.MemberDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberBO {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int createMember(Member member) {
		
		return memberDAO.insertMember(member);
	}

	public Member getMemberByTeamIdAndRank(int teamId) {

		return memberDAO.selectMemberByTeamIdAndRank(teamId);
	}

	public int getCountMemberByTeamId(Member member) {

		return memberDAO.selectCountMemberByTeamId(member);
	}

	public int addMemberBySupport(int userId, int teamId) {

		return memberDAO.insertMemberBySupport(userId, teamId);
	}

	public boolean isMember(int userId, int teamId) {

		int count = memberDAO.countMemberById(userId, teamId);

		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}



	public List<Member> getMemberListByUserId(int userId) {

		return memberDAO.selectMemberListByUserId(userId);
	}




}
