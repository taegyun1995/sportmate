package com.project.sportmate.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.sportmate.user.model.User;
import com.project.sportmate.user.model.UserM;

import java.util.List;

@Repository
public interface UserDAO {
	
	public int insertUser(UserM userM);
	
	public int overlapLoginId(User user);
	
	public User getUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	public String getLoginId(
			@Param("name") String name
			, @Param("phoneNum") String phoneNum);
	
	public int overlapPassword(
			@Param("loginId") String loginId
			, @Param("email") String email);
	
	public int updatePassword(
			@Param("password") String password
			, @Param("loginId") String loginId
			, @Param("email") String email);
	
	public User selectUserById(@Param("id") int id);
	
	public int updateProfile(
			@Param("userId") int userId
			, @Param("profileImage") String profileImage
			, @Param("nickName") String nickName
			, @Param("exercise") String exercise
			, @Param("region") String region
			, @Param("content") String content);

}
