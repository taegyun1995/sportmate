package com.project.sportmate.main.team.dao;

import com.project.sportmate.main.team.model.Team;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDAO {

    public int addTeam(
            @Param("userId") int userId
            , @Param("teamname") String teamname
            , @Param("exercise") String exercise
            , @Param("region") String region
            , @Param("content") String content);

    public List<Team> selectTeamList(@Param("userId") int userId);

    public List<Team> selectTeamListById(@Param("teamIdList") List<Integer> teamIdList);


}
