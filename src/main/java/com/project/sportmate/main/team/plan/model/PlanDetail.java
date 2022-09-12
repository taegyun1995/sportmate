package com.project.sportmate.main.team.plan.model;

import com.project.sportmate.main.profile.model.Story;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.user.model.User;

public class PlanDetail {

    private Plan plan;

    private Team team;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
