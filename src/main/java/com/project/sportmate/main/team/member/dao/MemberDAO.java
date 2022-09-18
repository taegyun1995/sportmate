package com.project.sportmate.main.team.member.dao;

import com.project.sportmate.main.team.member.model.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	public int insertMember(Member member);

}
