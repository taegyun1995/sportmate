package com.project.sportmate.main.hunt.applicant.bo;

import com.project.sportmate.main.hunt.applicant.dao.ApplicantDAO;
import com.project.sportmate.main.hunt.applicant.model.Applicant;
import com.project.sportmate.main.hunt.applicant.model.ApplicantDetail;
import com.project.sportmate.main.hunt.model.Hunt;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantBO {

    @Autowired
    private ApplicantDAO applicantDAO;
    @Autowired
    private UserBO userBO;

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

    public int deleteSupport(int huntId, int userId) {

        return applicantDAO.deleteSupport(huntId, userId);
    }

    public List<ApplicantDetail> getApplicantMembers(int huntId) {

        List<Applicant> applicantList = applicantDAO.selectSupportByHuntId(huntId);
        List<ApplicantDetail> applicantDetailList = new ArrayList<>();

        for(Applicant applicant : applicantList) {
            ApplicantDetail applicantDetail = new ApplicantDetail();

            int userId = applicant.getUserId();
            User user = userBO.getUserById(userId);

            applicantDetail.setApplicant(applicant);
            applicantDetail.setUser(user);
            applicantDetailList.add(applicantDetail);
        }

        return applicantDetailList;
    }

    public int deleteSupportById(int id) {

        return applicantDAO.deleteSupportById(id);
    }


}
