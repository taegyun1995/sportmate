package com.project.sportmate.main.team.plan.bo;

import com.project.sportmate.main.team.plan.dao.PlanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanBO {

    @Autowired
    private PlanDAO planDAO;

    public int createPlan(int userId, int teamId, String plan) {
        return planDAO.insertPlan(userId, teamId, plan);
    }
}
