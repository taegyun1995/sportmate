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
    private TeamBO teamBO;
    @Autowired
    private UserBO userBO;

    public int createPlan(int userId, int teamId, String plan) {

        return planDAO.insertPlan(userId, teamId, plan);
    }

    public List<PlanDetail> getPlanDetailList(int userId) {

        List<PlanDetail> planDetailList = new ArrayList<>();
        List<Plan> planList = planDAO.selectPlanList(userId);
        List<Integer> teamIdList = planList.stream().map(p -> p.getTeamId()).toList();
        List<Team> teamList = teamBO.getTeamListById(teamIdList);

        for (Plan plan : planList) {
            PlanDetail planDetail = new PlanDetail();
            User user = userBO.getUserById(userId);
            Team team = teamList.stream()
                    .filter(t -> t.getId() == plan.getTeamId())
                    .findFirst().get();

            planDetail.setPlan(plan);
            planDetail.setUser(user);
            planDetail.setTeam(team);

            planDetailList.add(planDetail);
        }

        return planDetailList;
    }

    public int deletePlan(int planId, int userId) {

        return planDAO.deletePlan(planId, userId);
    }


}
