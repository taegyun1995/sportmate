package com.project.sportmate.main.profile.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.main.profile.comment.dao.CommentDAO;
import com.project.sportmate.main.profile.comment.model.Comment;
import com.project.sportmate.main.profile.comment.model.CommentDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private UserBO userBO;
	
	public int createComment(int userId, int storyId, String comment) {
		
		return commentDAO.insertComment(userId, storyId, comment);
	}
	
	public List<CommentDetail> getCommentList(int storyId) {
		
		List<Comment> commentList = commentDAO.selectCommentByStoryId(storyId);
		List<CommentDetail> commentDetailList = new ArrayList<>();
		
		for(Comment comment : commentList) {
			
			int userId = comment.getUserId();
			User user = userBO.getUserById(userId);
			
			CommentDetail commentDetail = new CommentDetail();
			commentDetail.setComment(comment);
			commentDetail.setUser(user);
			
			commentDetailList.add(commentDetail);
		}
		
		return commentDetailList;
	}
	
	public int deleteComment(int userId, int commentId) {
		
		return commentDAO.deleteComment(userId, commentId);
	}

	public int deleteStoryComment(int storyId) {

		return commentDAO.deleteStoryComment(storyId);
	}
	
	
}
