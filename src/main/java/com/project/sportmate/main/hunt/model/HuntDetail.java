package com.project.sportmate.main.hunt.model;

import com.project.sportmate.main.team.model.Team;

public class HuntDetail {

    private Hunt hunt;

    public Hunt getHunt() {
        return hunt;
    }

    public void setHunt(Hunt hunt) {
        this.hunt = hunt;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    private Team team;
}
