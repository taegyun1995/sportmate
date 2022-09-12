package com.project.sportmate.main.team.member.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.main.team.member.dao.MemberDAO;

@Service
public class MemberBO {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int createMember(int userId, String rank) {
		
		return memberDAO.insertMember(userId, rank);
	}
	
}
