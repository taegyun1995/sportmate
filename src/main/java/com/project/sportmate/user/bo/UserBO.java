package com.project.sportmate.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.sportmate.common.EncryptUtils;
import com.project.sportmate.common.FileManagerService;
import com.project.sportmate.user.dao.UserDAO;
import com.project.sportmate.user.model.User;
import com.project.sportmate.user.model.UserM;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	// 회원가입
	public int signupUser(UserM userM) {
		
		int id = userM.getId();
		MultipartFile profileImage = userM.getProfileImage();
		String imagePath = null;
		
		imagePath = FileManagerService.saveProfileImgFile(id, profileImage);
		String encryptPassword = EncryptUtils.md5(userM.getPassword());
		
		userM.setImagePath(imagePath);
		userM.setPassword(encryptPassword);
		
		return userDAO.insertUser(userM);
	}
	
	// 아이디 중복확인
	public boolean overlapUser(User user) {
		
		int count = userDAO.overlapLoginId(user);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 로그인
	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.getUser(loginId, encryptPassword);
	}
	
	// 아이디 변경 
	public String getLoginId(String name, String phoneNum) {
		
		return userDAO.getLoginId(name, phoneNum);
		
	}
	
	// 비밀번호 관련 조회
	public boolean changePw(String loginId, String email) {
		
		int count = userDAO.overlapPassword(loginId, email);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	// 비밀번호 변경
	public int updatePw(String password, String loginId, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.updatePassword(encryptPassword, loginId, email);
		
	}
	
	public User getUserById(int userId) {
		
		return userDAO.selectUserById(userId);
	}
	
	// 프로필 수정
	public int editProfile(int userId, MultipartFile profileImage, String nickName, String exercise, String region, String content) {
		String imagePath = null;

		// 긍정맨
		if(!profileImage.isEmpty()) {
			// upload
			imagePath = FileManagerService.editProfileImgFile(userId, profileImage);
		} else {
			// ???
			User user = userDAO.selectUserById(userId);
			imagePath = user.getProfileImage();
		}
		
		return userDAO.updateProfile(userId, imagePath, nickName, exercise, region, content);
	}
	
}
