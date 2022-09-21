package com.project.sportmate.main.team.plan.dao;

import com.project.sportmate.main.team.plan.model.Plan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanDAO {

    public int insertPlan(
            @Param("userId") int userId,
            @Param("teamId") int teamId,
            @Param("plan") String plan);

    public List<Plan> selectPlanList(@Param("userId") int userId);

    public int deletePlan(@Param("planId") int planId, @Param("userId") int userId);
}
