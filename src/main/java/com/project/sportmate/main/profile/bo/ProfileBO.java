package com.project.sportmate.main.profile.bo;

import java.util.ArrayList;
import java.util.List;

import com.project.sportmate.main.team.member.bo.MemberBO;
import com.project.sportmate.main.team.member.model.Member;
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
	@Autowired
	private MemberBO memberBO;
	
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
			int likeCount = likeBO.countLike(storyId);
			boolean isLike = likeBO.isLike(storyId, userId);
			List<CommentDetail> commentList = commentBO.getCommentList(storyId);
			
			StoryDetail storyDetail = new StoryDetail();
			storyDetail.SetStory(story);
			storyDetail.setUser(user);
			storyDetail.setLikeCount(likeCount);
			storyDetail.setlike(isLike);
			storyDetail.setComment(commentList);
			
			storyDetailList.add(storyDetail);
		}
		
		return storyDetailList;
	}

	public int deleteStory(int storyId, int userId) {

		Story story = profileDAO.selectStory(storyId);
		int count =  profileDAO.deleteStory(storyId, userId);

		if(count == 1) {
			FileManagerService.removeFile(story.getStoryImage());
			commentBO.deleteStoryComment(storyId);
			likeBO.deleteStoryLike(storyId);
		}

		return count;
	}

	public List<StoryDetail> getAwesomeTeamStoryListByUserId(int userId) {

		List<Member> memberListByUserId = memberBO.getMemberListByUserId(userId);
		List<Integer> storyIdList = new ArrayList();

		for (Member member : memberListByUserId) {
			storyIdList.add(member.getTeamId());
		}

		return this.getTeamStoryListByUserId(storyIdList, userId);
	}

	public List<StoryDetail> getTeamStoryListByUserId(List<Integer> storyIdList, int userId) {

		List<StoryDetail> storyDetailTeamList = new ArrayList<>();
		List<Story> storyList = profileDAO.selectStoryListById(storyIdList);

		for(Story story : storyList) {
			StoryDetail storyTeamDetail = new StoryDetail();
			int user_id = story.getUserId();
			int storyId = story.getId();

			User user = userBO.getUserById(user_id);
			int likeCount = likeBO.countLike(storyId);
			boolean isLike = likeBO.isLike(storyId, userId);
			List<CommentDetail> commentList = commentBO.getCommentList(storyId);

			storyTeamDetail.SetStory(story);
			storyTeamDetail.setUser(user);
			storyTeamDetail.setLikeCount(likeCount);
			storyTeamDetail.setlike(isLike);
			storyTeamDetail.setComment(commentList);

			storyDetailTeamList.add(storyTeamDetail);
		}

		return storyDetailTeamList;
	}



	
}
