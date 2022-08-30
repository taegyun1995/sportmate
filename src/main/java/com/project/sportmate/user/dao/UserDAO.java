package com.project.sportmate.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.sportmate.user.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("phoneNum") String phoneNum
			, @Param("birth") int birth
			, @Param("email") String email);
	
	public int overlapLoginId(@Param("loginId") String loginId);
	
	public User getUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	public User getUserbyId(@Param("id") int id);
	
	public String getLoginId(
			@Param("name") String name
			, @Param("phoneNum") String phoneNum);
	
	public int overlapPassword(
			@Param("loginId") String loginId
			, @Param("email") String email);
	
	
}
