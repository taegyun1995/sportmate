package com.project.sportmate.main.hunt.applicant.model;

import java.util.Date;

public class Applicant {

    private int id;
    private int userId;
    private int huntId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHuntId() {
        return huntId;
    }

    public void setHuntId(int huntId) {
        this.huntId = huntId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Date createdAt;

}
