package com.project.sportmate.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.sportmate.common.EncryptUtils;
import com.project.sportmate.common.FileManagerService;
import com.project.sportmate.user.dao.UserDAO;
import com.project.sportmate.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int signupUser(MultipartFile profileImage, String loginId, String password, String name, String nickName, String phoneNum,
			int birth, String gender, String exercise, String region, String content, String email) {
		
		String imagePath = FileManagerService.saveProfileImgFile(loginId, profileImage);
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(imagePath, loginId, encryptPassword, name, nickName, phoneNum, birth, gender, exercise, region, content, email);
	}
	
	public boolean overlapUser(String loginId) {
		
		int count = userDAO.overlapLoginId(loginId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}

	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.getUser(loginId, encryptPassword);
	}
	
	public String getLoginId(String name, String phoneNum) {
		
		return userDAO.getLoginId(name, phoneNum);
		
	}
	
	public boolean changePw(String loginId, String email) {
		
		int count = userDAO.overlapPassword(loginId, email);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public int updatePw(String password, String loginId, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.updatePassword(encryptPassword, loginId, email);
		
	}
	
	public int editProfile(MultipartFile profileImage, String loginId, String nickName, String exercise, String region, String content) {
		
		String imagePath = FileManagerService.saveProfileImgFile(loginId, profileImage);
		
		return userDAO.updateProfile(imagePath, loginId, nickName, exercise, region, content);
	}
	
	public User getUserById(int id) {
		return userDAO.selectUserById(id);
	}
	
}
