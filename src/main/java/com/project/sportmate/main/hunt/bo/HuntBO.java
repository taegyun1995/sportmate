package com.project.sportmate.main.hunt.bo;

import com.project.sportmate.main.hunt.dao.HuntDAO;
import com.project.sportmate.main.hunt.model.Hunt;
import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.user.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuntBO {

    @Autowired
    private HuntDAO huntDAO;

    public int addHunt(Hunt hunt) {

        return huntDAO.insertHunt(hunt);
    }

    public Hunt getHunt(int id) {

        return huntDAO.selectHunt(id);
    }


}
