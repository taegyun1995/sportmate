package com.project.sportmate.main.profile.like.bo;

import com.project.sportmate.main.profile.like.dao.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		int count = likeDAO.countLikeById(storyId, userId);

		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int deleteStoryLike(int storyId) {

		return likeDAO.deleteStoryLike(storyId);
	}
}
