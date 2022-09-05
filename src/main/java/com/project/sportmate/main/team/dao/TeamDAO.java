package com.project.sportmate.main.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.sportmate.main.team.model.Team;

@Repository
public interface TeamDAO {
	
	public int addTeam(
			@Param("userId") int userId
			, @Param("teamname") String teamname
			, @Param("exercise") String exercise
			, @Param("region") String region
			, @Param("content") String content);
	
	public List<Team> selectTeamList(@Param("userId") int userId);

}
