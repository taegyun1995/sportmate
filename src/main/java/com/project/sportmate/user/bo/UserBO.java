package com.project.sportmate.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportmate.common.EncryptUtils;
import com.project.sportmate.user.dao.UserDAO;
import com.project.sportmate.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int signupUser(String loginId, String password, String name, String phoneNum, int birth, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, name, phoneNum, birth, email);
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
	
	public User getUserById(int id) {
		
		return userDAO.getUserbyId(id);
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

}
