package com.project.sportmate.main.profile.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.sportmate.main.profile.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	public int insertComment(
			@Param("userId") int userId
			, @Param("storyId") int storyId
			, @Param("comment") String comment);
	
	public List<Comment> selectCommentByStoryId(@Param("storyId") int storyId);
	
	public int deleteComment(
			@Param("userId") int userId
			, @Param("commentId") int commentId);

	public int deleteStoryComment(@Param("storyId") int storyId);
}
