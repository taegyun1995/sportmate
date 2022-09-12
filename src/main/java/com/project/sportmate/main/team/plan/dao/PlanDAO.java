package com.project.sportmate.main.team.plan.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDAO {

    public int insertPlan(
            @Param("userId") int userId,
            @Param("teamId") int teamId,
            @Param("plan") String plan);
}
