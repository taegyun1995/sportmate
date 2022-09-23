package com.project.sportmate.main.hunt.model;

import com.project.sportmate.main.hunt.applicant.model.Applicant;
import com.project.sportmate.main.hunt.applicant.model.ApplicantDetail;
import com.project.sportmate.main.team.model.Team;
import com.project.sportmate.user.model.User;

import java.util.List;

public class HuntDetail {

    private User user;
    private Hunt hunt;
    private Team team;
    private boolean isSupport;
    private Applicant applicant;

    public List<ApplicantDetail> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<ApplicantDetail> applicants) {
        this.applicants = applicants;
    }

    private List<ApplicantDetail> applicants;

    public boolean isSupport() {
        return isSupport;
    }

    public void setSupport(boolean support) {
        isSupport = support;
    }

    public Applicant getApplicant() {

        return applicant;
    }

    public void setApplicant(Applicant applicant) {

        this.applicant = applicant;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
