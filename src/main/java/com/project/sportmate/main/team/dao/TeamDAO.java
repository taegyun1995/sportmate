package com.project.sportmate.main.team.dao;

import com.project.sportmate.main.team.model.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDAO {


    public int addTeam(Team team);

    public List<Team> selectTeamList(@Param("userId") int userId);

    public List<Team> selectTeamListById(@Param("teamIdList") List<Integer> teamIdList);

    public Team selectTeamById(@Param("id") int id);
}
