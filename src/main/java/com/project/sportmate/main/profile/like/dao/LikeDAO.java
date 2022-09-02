package com.project.sportmate.main.profile.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	public int insertLike(
			@Param("userId") int userId
			, @Param("storyId") int storyId);
		
	
	public int deleteLike(
			@Param("storyId") int storyId
			, @Param("userId") int userId);
	
	public int countLike(@Param("storyId") int storyId);
	
	public int CountLikeById(
			@Param("storyId") int storyId
			, @Param("userId") int userId);
}
