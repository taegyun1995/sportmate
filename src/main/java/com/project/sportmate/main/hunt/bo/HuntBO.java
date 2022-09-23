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
    private ApplicantBO applicantBO;
    @Autowired
    private UserBO userBO;

    public int addHunt(Hunt hunt) {

        return huntDAO.insertHunt(hunt);
    }

    public List<HuntDetail> huntList(int userId) {
        List<Hunt> huntList = huntDAO.selectHuntList();
        List<HuntDetail> huntDetailList = new ArrayList<>();

        List<Integer> teamIdList = huntList.stream().map(h -> h.getTeamId()).toList();
        List<Team> teamList = teamBO.getTeamListById(teamIdList);

        for(Hunt hunt : huntList) {
            int user_id = hunt.getUserId();
            int huntId = hunt.getId();

            HuntDetail huntDetail = new HuntDetail();
            huntDetail.setHunt(hunt);

            User user = userBO.getUserById(user_id);
            huntDetail.setUser(user);

            Team team = teamList.stream()
                    .filter(t -> t.getId() == hunt.getTeamId())
                    .findFirst().get();

            huntDetail.setTeam(team);

            boolean isSupport = applicantBO.isSupport(huntId, userId);
            huntDetail.setIsSupport(isSupport);

            huntDetailList.add(huntDetail);
        }

        return huntDetailList;
    }

    public HuntDetail getHuntById(Hunt hunt) {

        HuntDetail huntDetail = new HuntDetail();

        Hunt getHunt =  huntDAO.selectHuntListById(hunt);
        Team team = teamBO.getTeamById(getHunt.getTeamId());
        List<ApplicantDetail> applicantList = applicantBO.getApplicantMembers(getHunt.getId());

        huntDetail.setHunt(getHunt);
        huntDetail.setTeam(team);
        huntDetail.setApplicants(applicantList);

        return huntDetail;
    }







}
