package com.project.sportmate.main.hunt.applicant.dao;

import com.project.sportmate.main.hunt.applicant.model.Applicant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantDAO {

    public int insertSupport(Applicant applicant);

    public int countSupportById(
            @Param("huntId") int huntId
            , @Param("userId") int userId);

    public int deleteSupport(
            @Param("huntId") int huntId
            , @Param("userId") int userId);

    public List<Applicant> selectSupportByHuntId(@Param("huntId") int huntId);

    public int deleteSupportById(@Param("id") int id);

    public Applicant selectSupport(@Param("id") int id);

}
