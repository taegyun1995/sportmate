package com.project.sportmate.main.team.member.model;

import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.user.model.User;

import java.util.List;

public class MemberDetail {

    private Member member;
    private User user;
    private Team team;

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    private List<Team> teamList;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
