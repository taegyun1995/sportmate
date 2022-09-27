package com.project.sportmate.main.team.member.model;

import com.project.sportmate.user.model.User;

public class MemberDetail {

    private Member member;

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

    private User user;
}
