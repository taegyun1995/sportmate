package com.project.sportmate.main.team.member.bo;

import com.project.sportmate.main.team.member.model.Member;
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
