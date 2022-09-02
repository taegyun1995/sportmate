package com.project.sportmate.main.profile.model;

import com.project.sportmate.user.model.User;

public class StoryDetail {
	
	private User user;
	
	private Story story;
	
	private int likeCount;
	
	private boolean islike;
	
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
