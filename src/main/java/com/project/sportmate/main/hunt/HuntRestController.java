package com.project.sportmate.main.hunt;

import com.project.sportmate.main.hunt.bo.HuntBO;
import com.project.sportmate.main.hunt.model.Hunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HuntRestController {

    @Autowired
    private HuntBO huntBO;

    @GetMapping("/hunt/make")
    public Map<String, String> createHunt(
            HttpServletRequest request
            , @ModelAttribute Hunt hunt) {

        HttpSession session = request.getSession();
        int userId = (Integer)session.getAttribute("userId");
        hunt.setUserId(userId);

        Map<String, String> map = new HashMap<>();
        int count = huntBO.addHunt(hunt);

        if(count == 1) {
            map.put("result", "success");
        }else {
            map.put("result", "success");
        }

        return map;
    }

    @GetMapping("/hunt/update")
    public Map<String, String> updateHunt(@ModelAttribute Hunt hunt) {

        Map<String, String> map = new HashMap<>();
        int count = huntBO.huntUpdate(hunt);

        if(count == 1) {
            map.put("result", "success");
        }else {
            map.put("result", "success");
        }

        return map;
    }



}
