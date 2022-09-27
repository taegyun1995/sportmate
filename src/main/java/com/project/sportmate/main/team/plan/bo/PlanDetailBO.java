package com.project.sportmate.main.team.plan.bo;

import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.dao.TeamDAO;
import com.project.sportmate.main.team.member.bo.MemberBO;
import com.project.sportmate.main.team.member.model.Member;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.main.team.model.TeamDetail;
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
public class PlanDetailBO {

    @Autowired
    private MemberBO memberBO;
    @Autowired
    private PlanDAO planDAO;
    @Autowired
    private TeamBO teamBO;
    @Autowired
    private UserBO userBO;

    public List<PlanDetail> getAwesomePlanListByUserId(int userId) {

        List<Member> memberListByUserId = memberBO.selectMemberListByUserId(userId);
        List<Integer> planIdList = new ArrayList();

        for (Member member : memberListByUserId) {
            planIdList.add(member.getTeamId());
        }

        return this.getPlanListByIdList(planIdList);
    }

    public List<PlanDetail> getPlanListByIdList(List<Integer> planIdList) {

        List<PlanDetail> planDetailList = new ArrayList<>();
        List<Plan> planList = planDAO.selectPlanListById(planIdList);

        for (Plan plan : planList) {
            PlanDetail planDetail = new PlanDetail();
            Team team = teamBO.getTeamById(plan.getTeamId());
            User user = userBO.getUserById(plan.getUserId());

            planDetail.setTeam(team);
            planDetail.setPlan(plan);
            planDetail.setUser(user);
            planDetailList.add(planDetail);
        }

        return planDetailList;
    }
}
