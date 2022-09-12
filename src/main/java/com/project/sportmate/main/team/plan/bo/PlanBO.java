package com.project.sportmate.main.team.plan.bo;

import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.plan.dao.PlanDAO;
import com.project.sportmate.main.team.plan.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanBO {

    @Autowired
    private PlanDAO planDAO;

    @Autowired
    private TeamBO teamBo;

    public int createPlan(int userId, int teamId, String plan) {
        return planDAO.insertPlan(userId, teamId, plan);
    }

    public List<Plan> getPlanList(int userId) {
        return planDAO.selectPlanList(userId);
    }

}
