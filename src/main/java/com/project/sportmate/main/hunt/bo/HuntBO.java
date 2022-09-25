package com.project.sportmate.main.hunt.bo;

import com.project.sportmate.main.hunt.applicant.bo.ApplicantBO;
import com.project.sportmate.main.hunt.applicant.model.Applicant;
import com.project.sportmate.main.hunt.applicant.model.ApplicantDetail;
import com.project.sportmate.main.hunt.dao.HuntDAO;
import com.project.sportmate.main.hunt.model.Hunt;
import com.project.sportmate.main.hunt.model.HuntDetail;
import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HuntBO {

    @Autowired
    private HuntDAO huntDAO;
    @Autowired
    private TeamBO teamBO;
    @Autowired
    private UserBO userBO;

    public int addHunt(Hunt hunt) {

        return huntDAO.insertHunt(hunt);
    }



    public Hunt getHunt(int id) {

        return huntDAO.selectHunt(id);
    }







}
