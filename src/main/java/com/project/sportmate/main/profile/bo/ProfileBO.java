package com.project.sportmate.main.profile.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.sportmate.common.FileManagerService;
import com.project.sportmate.main.profile.dao.ProfileDAO;
import com.project.sportmate.main.profile.model.Story;

@Service
public class ProfileBO {
	
	@Autowired
	private ProfileDAO profileDAO;
	
	public int addStory(int userId, MultipartFile storyImage, String content) {
		String imagePath = FileManagerService.saveStoryImgFile(userId, storyImage);
		
		return profileDAO.storyInsert(userId, imagePath, content);
	}
	
	public List<Story> getStoryList(int userId) {
		
		List<Story> storyList = profileDAO.selectUserStoryList(userId);
		
		return storyList;
	}
	
}
