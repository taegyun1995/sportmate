package com.project.sportmate.main.profile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.sportmate.main.profile.model.Story;

public interface ProfileDAO {
	
	public int storyInsert(
			@Param("userId") int userId
			, @Param("storyImage") String storyImage
			, @Param("content") String content);

	public List<Story> selectUserStoryList(@Param("userId") int userId);
	
	public int deleteStory(
			@Param("storyId") int storyId
			, @Param("usrId") int userId);
	
	public Story selectStory(@Param("storyId") int storyId);
	
	
	
}
