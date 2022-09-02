package com.project.sportmate.main.profile.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.main.profile.like.dao.LikeDAO;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	public int addLike(int userId, int storyId) {
		
		return likeDAO.insertLike(userId, storyId);
	}
	
	public int deleteLike(int storyId, int userId) {
		
		return likeDAO.deleteLike(storyId, userId);
	}
	
	public int countLike(int storyId) {
		
		return likeDAO.countLike(storyId);
	}
	
	public boolean isLike(int storyId, int userId) {
		
		int count = likeDAO.CountLikeById(storyId, userId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
}
