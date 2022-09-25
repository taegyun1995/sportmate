package com.project.sportmate.main.team.member.dao;

import com.project.sportmate.main.team.member.model.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	public int insertMember(Member member);

	public Member selectMemberByTeamId(@Param("teamId") int teamId);

	public int selectCountMemberByTeamId(Member member);

	public int insertMemberBySupport(@Param("userId") int userId, @Param("teamId") int teamId);

	public int countMemberById(@Param("userId") int userId, @Param("teamId") int teamId);

}
