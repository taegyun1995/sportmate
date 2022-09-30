package com.project.sportmate.main.hunt.applicant;

import com.project.sportmate.main.hunt.applicant.bo.ApplicantBO;
import com.project.sportmate.main.hunt.applicant.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicantRestController {

    @Autowired
    private ApplicantBO applicantBO;

    @GetMapping("/hunt/support")
    public Map<String, String> support(
            HttpServletRequest request
            , @ModelAttribute Applicant applicant) {

        HttpSession session = request.getSession();
        int userId = (Integer)session.getAttribute("userId");
        applicant.setUserId(userId);

        Map<String, String> map = new HashMap<>();
        int count = applicantBO.insertSupport(applicant);

        if(count == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }

        return map;
    }

    @GetMapping("/hunt/unSupport")
    public Map<String, String> unSupport(
            HttpServletRequest request
            , @RequestParam("huntId") int huntId) {

        HttpSession session = request.getSession();
        int userId = (Integer)session.getAttribute("userId");

        Map<String, String> map = new HashMap<>();
        int count = applicantBO.deleteSupport(huntId, userId);

        if(count == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }

        return map;
    }

    @GetMapping("/hunt/nonPass")
    public Map<String, String> supportDelete(@RequestParam("id") int id) {

        Map<String, String> map = new HashMap<>();
        int count = applicantBO.deleteSupportById(id);

        if(count == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }

        return map;
    }

    @GetMapping("/hunt/pass")
    public Map<String, String> addNormalMember(@RequestParam("id") int id) {

        Map<String, String> map = new HashMap<>();
        int count = applicantBO.deleteSupportAndInsertMember(id);

        if(count == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }

        return map;
    }

}
