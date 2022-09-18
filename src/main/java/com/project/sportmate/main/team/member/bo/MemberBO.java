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
	
}
