package com.project.sportmate.main.team.plan.bo;

import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.plan.dao.PlanDAO;
import com.project.sportmate.main.team.plan.model.Plan;
import com.project.sportmate.main.team.plan.model.PlanDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanBO {

    @Autowired
    private PlanDAO planDAO;
    @Autowired
    private UserBO userBO;

    public int createPlan(int userId, int teamId, String plan) {

        return planDAO.insertPlan(userId, teamId, plan);
    }

    public int deletePlan(int planId, int userId) {

        return planDAO.deletePlan(planId, userId);
    }

    public Plan selectPlan(int userId, int teamId) {

        return planDAO.selectPlanList(userId, teamId);
    }

}
