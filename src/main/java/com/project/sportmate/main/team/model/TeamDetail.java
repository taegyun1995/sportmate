package com.project.sportmate.main.team.model;

import com.project.sportmate.main.profile.comment.model.Comment;
import com.project.sportmate.main.profile.comment.model.CommentDetail;
import com.project.sportmate.main.profile.model.Story;
import com.project.sportmate.main.team.member.model.Member;
import com.project.sportmate.user.model.User;

import java.util.List;

public class TeamDetail {
	
	private Team team;
	private Member member;
	private Story story;
	private User user;
	private int likeCount;
	private boolean islike;
	public int memberCount;

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}


	private List<CommentDetail> comment ;
	public List<CommentDetail> getComment() {
		return comment;
	}
	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}
	public void setComment(List<CommentDetail> comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public boolean isIslike() {
		return islike;
	}

	public void setIslike(boolean islike) {
		this.islike = islike;
	}

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
	
	
}
