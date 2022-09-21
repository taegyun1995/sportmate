package com.project.sportmate.main.hunt.model;

import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.user.model.User;

public class HuntDetail {

    private Hunt hunt;
    private Team team;
    private boolean isSupport;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public boolean isIsSupport() {
        return isSupport;
    }

    public void setIsSupport(boolean isSupport) {
        this.isSupport = isSupport;
    }

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


}
