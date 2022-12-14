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

    public Plan selectPlanList(@Param("userId") int userId, @Param("teamId") int teamId);

    public List<Plan> selectPlanListById(@Param("planIdList") List<Integer> planIdList);

    public int deletePlan(@Param("planId") int planId, @Param("userId") int userId);


}
