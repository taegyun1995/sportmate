package com.project.sportmate.main.profile.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.sportmate.common.FileManagerService;
import com.project.sportmate.main.profile.comment.bo.CommentBO;
import com.project.sportmate.main.profile.comment.model.CommentDetail;
import com.project.sportmate.main.profile.dao.ProfileDAO;
import com.project.sportmate.main.profile.like.bo.LikeBO;
import com.project.sportmate.main.profile.model.Story;
import com.project.sportmate.main.profile.model.StoryDetail;
import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;

@Service
public class ProfileBO {
	
	@Autowired
	private ProfileDAO profileDAO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private CommentBO commentBO;
	
	public int addStory(int userId, MultipartFile storyImage, String content) {
		String imagePath = FileManagerService.saveStoryImgFile(userId, storyImage);
		
		return profileDAO.storyInsert(userId, imagePath, content);
	}
	
	public List<StoryDetail> getStoryList(int userId) {
		
		List<StoryDetail> storyDetailList = new ArrayList<>();
		List<Story> storyList = profileDAO.selectUserStoryList(userId);
		
		for(Story story : storyList) {
			
			int user_id = story.getUserId();
			int storyId = story.getId();
			
			User user = userBO.getUserById(user_id);
			int likecount = likeBO.countLike(storyId);
			boolean islike = likeBO.isLike(storyId, userId);
			List<CommentDetail> commentList = commentBO.getCommentList(storyId);
			
			StoryDetail storyDetail = new StoryDetail();
			storyDetail.SetStory(story);
			storyDetail.setUser(user);
			storyDetail.setLikeCount(likecount);
			storyDetail.setlike(islike);
			storyDetail.setComment(commentList);
			
			storyDetailList.add(storyDetail);
		}
		
		return storyDetailList;
	}
	
	public int deleteStory(int storyId, int userId) {
		
		return profileDAO.deleteStory(storyId, userId);
	}
	
}
