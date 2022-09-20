package com.project.sportmate.main.hunt;

import com.project.sportmate.main.hunt.bo.HuntBO;
import com.project.sportmate.main.hunt.model.HuntDetail;
import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.model.TeamDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HuntController {

    @Autowired
    private HuntBO huntBO;
    @Autowired
    private TeamBO teamBO;

    @GetMapping("/sportmate/hunt/detail/view")
    public String huntDetailView(Model model) {

        List<HuntDetail> huntList = huntBO.huntList();
        model.addAttribute("huntList", huntList);

        return "/hunt/detail";
    }
    @GetMapping("/sportmate/hunt/create/view")
    public String huntcreateView(Model model
            , HttpServletRequest request) {

        HttpSession session = request.getSession();
        int userId = (Integer)session.getAttribute("userId");

        List<TeamDetail> teamList = teamBO.getTeamList(userId);
        model.addAttribute("teamlist", teamList);

        return "/hunt/create";
    }

}
