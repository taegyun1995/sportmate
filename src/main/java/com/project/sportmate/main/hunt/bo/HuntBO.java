package com.project.sportmate.main.hunt.bo;

import com.project.sportmate.main.hunt.dao.HuntDAO;
import com.project.sportmate.main.hunt.model.Hunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuntBO {

    @Autowired
    private HuntDAO huntDAO;

    public int addHunt(Hunt hunt) {

        return huntDAO.insertHunt(hunt);
    }
}
