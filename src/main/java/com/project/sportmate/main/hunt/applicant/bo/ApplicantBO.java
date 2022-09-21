package com.project.sportmate.main.hunt.applicant.bo;

import com.project.sportmate.main.hunt.applicant.dao.ApplicantDAO;
import com.project.sportmate.main.hunt.applicant.model.Applicant;
import com.project.sportmate.main.hunt.model.Hunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantBO {

    @Autowired
    private ApplicantDAO applicantDAO;

    public int insertSupport(Applicant applicant) {

        return applicantDAO.insertSupport(applicant);
    }

    public boolean isSupport(int huntId, int userId) {
        int count = applicantDAO.countSupportById(huntId, userId);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }


}
