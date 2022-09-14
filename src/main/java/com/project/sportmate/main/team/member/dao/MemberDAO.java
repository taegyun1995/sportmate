package com.project.sportmate.main.team.member.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	public int insertMember(
			@Param("userId") int userId
			, @Param("teamId") int teamId
			, @Param("rank") String rank);

}
