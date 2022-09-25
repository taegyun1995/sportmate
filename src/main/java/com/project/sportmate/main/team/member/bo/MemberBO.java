package com.project.sportmate.main.team.member.bo;

import com.project.sportmate.main.team.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.main.team.member.dao.MemberDAO;

@Service
public class MemberBO {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int createMember(Member member) {
		
		return memberDAO.insertMember(member);
	}

	public Member selectMemberByTeamId(int teamId) {

		return memberDAO.selectMemberByTeamId(teamId);
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
	
}
