package com.project.sportmate.main.profile.model;

import java.util.List;

import com.project.sportmate.main.profile.comment.model.CommentDetail;
import com.project.sportmate.user.model.User;

public class StoryDetail {
	
	private User user;
	
	private Story story;
	
	private int likeCount;
	
	private boolean islike;
	
	private List<CommentDetail> comment ;
	
	public boolean isIslike() {
		return islike;
	}
	public void setIslike(boolean islike) {
		this.islike = islike;
	}
	public List<CommentDetail> getComment() {
		return comment;
	}
	public void setComment(List<CommentDetail> comment) {
		this.comment = comment;
	}
	public void setStory(Story story) {
		this.story = story;
	}
	public boolean islike() {
		return islike;
	}
	public void setlike(boolean islike) {
		this.islike = islike;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Story getStory() {
		return story;
	}
	public void SetStory(Story story) {
		this.story = story;
	}
	
}
