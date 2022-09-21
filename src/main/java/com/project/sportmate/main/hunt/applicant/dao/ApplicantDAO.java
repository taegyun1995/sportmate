package com.project.sportmate.main.hunt.applicant.dao;

import com.project.sportmate.main.hunt.applicant.model.Applicant;
import com.project.sportmate.main.hunt.model.Hunt;
import com.project.sportmate.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantDAO {

    public int insertSupport(Applicant applicant);

    public int countSupportById(
            @Param("huntId") int huntId
            , @Param("userId") int userId);


}
