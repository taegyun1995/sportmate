package com.project.sportmate.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.sportmate.user.bo.UserBO;
import com.project.sportmate.user.model.User;

@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입
	@PostMapping("/user/signup")
	public Map<String, String> userSignup(
			@RequestParam(value="profileImage", required=false) MultipartFile profileImage
			, @RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("nickName") String nickName
			, @RequestParam("phoneNum") String phoneNum
			, @RequestParam("birth") int birth
			, @RequestParam("gender") String gender
			, @RequestParam("exercise") String exercise
			, @RequestParam("region") String region
			, @RequestParam("content") String content
			, @RequestParam("email") String email) {
		
		Map<String, String> map = new HashMap<>();
		
		int count = userBO.signupUser(profileImage, loginId, password, name, nickName, phoneNum, birth, gender, exercise, region, content, email);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	// 아이디 중복 확인
	@GetMapping("/user/overlap_id")
	public Map<String, Boolean> idOverlap(String loginId) {
		Map<String, Boolean> result = new HashMap<>();
		
		if(userBO.overlapUser(loginId)) { // 중복된경우
			result.put("overlap", true);
		} else { // 중복되지 않은 경우 
			result.put("overlap", false);			
		}
		
		return result;
	}
	
	// 로그인
	@PostMapping("/user/signin")
	public Map<String, String> userSignin(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		
		User user = userBO.getUser(loginId, password);
		
		Map<String, String> map = new HashMap<>();
		
		if(user != null) { // 로그인 성공
			map.put("result", "success");
			
			HttpSession session = request.getSession();
			// user id, user loginId
			session.setAttribute("userId", user.getId());
			session.setAttribute("userProfileImage", user.getProfileImage());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userNickName", user.getNickName());
			session.setAttribute("userExercise", user.getExercise());
			session.setAttribute("userRegion", user.getRegion());
			
		} else { // 로그인 실패
			map.put("result", "fail");
			
		}
		return map;
	}
	
	// 아이디 찾기
	@GetMapping("/user/find/id")
	public Map<String, String> userfindId(String name, String phoneNum) {
		
		String loginId = userBO.getLoginId(name, phoneNum);
		
		Map<String, String> map = new HashMap<>();
		
		if(loginId != null) {
			map.put("result", "success");
			map.put("loginId", loginId);
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	// 비밀번호 조회
	@GetMapping("/user/overlap/password")
	public Map<String, Boolean> userchangePw(
			@RequestParam("loginId") String loginId
			, @RequestParam("email") String email) {
		
		Map<String, Boolean> result = new HashMap<>();
		if(userBO.changePw(loginId, email)) {
			result.put("overlap", true);
		} else { // 중복되지 않은 경우 
			result.put("overlap", false);			
		}
		
		return result;
	}
	
	// 비밀번호 변경
	@PostMapping("/user/change/password")
	public Map<String, String> changeUserPw(
			@RequestParam("password") String password
			, @RequestParam("loginId") String loginId
			, @RequestParam("email") String email) {
		
		Map<String, String> map = new HashMap<>();
		
		int count = userBO.updatePw(password, loginId, email);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	// 프로필 정보 변경
	@PostMapping("/profile/edit")
	public Map<String, String> editProfile(
			@RequestParam(value="profileImage", required=false) MultipartFile profileImage
			, @RequestParam("loginId") String loginId
			, @RequestParam("nickName") String nickName
			, @RequestParam("exercise") String exercise
			, @RequestParam("region") String region
			, @RequestParam("content") String content) {
		
		Map<String, String> map = new HashMap<>();
		
		int count = userBO.editProfile(profileImage, loginId, nickName, exercise, region, content);
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
}
