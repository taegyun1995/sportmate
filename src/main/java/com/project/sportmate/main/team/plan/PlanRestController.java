package com.project.sportmate.main.team.plan;

import com.project.sportmate.main.team.plan.bo.PlanBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PlanRestController {
    @Autowired
    private PlanBO planBO;

    @PostMapping("/team/plans/create")
    public Map<String, String> plans(Model model,
                                     @RequestParam("teamId") int teamId,
                                     @RequestParam("plan") String plan,
                                     HttpServletRequest request) {

        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");

        // teamId = get
        int count = planBO.createPlan(userId, teamId, plan);

        Map<String, String> map = new HashMap<>();
        if(count == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }

        return map;
    }

}
