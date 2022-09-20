package com.project.sportmate.main.hunt.bo;

import com.project.sportmate.main.hunt.dao.HuntDAO;
import com.project.sportmate.main.hunt.model.Hunt;
import com.project.sportmate.main.hunt.model.HuntDetail;
import com.project.sportmate.main.team.bo.TeamBO;
import com.project.sportmate.main.team.model.Team;
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

    public int addHunt(Hunt hunt) {

        return huntDAO.insertHunt(hunt);
    }

    public List<HuntDetail> huntList() {
        List<Hunt> huntList = huntDAO.selectHuntList();
        List<HuntDetail> huntDetailList = new ArrayList<>();
        List<Integer> teamIdList = huntList.stream().map(h -> h.getTeamId()).toList();
        List<Team> teamList = teamBO.getTeamListById(teamIdList);

        for(Hunt hunt : huntList) {
            HuntDetail huntDetail = new HuntDetail();
            huntDetail.setHunt(hunt);

            Team team = teamList.stream()
                    .filter(t -> t.getId() == hunt.getTeamId())
                    .findFirst().get();

            huntDetail.setTeam(team);
            huntDetailList.add(huntDetail);
        }

        return huntDetailList;
    }

}
