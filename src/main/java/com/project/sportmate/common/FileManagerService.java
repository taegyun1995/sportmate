package com.project.sportmate.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	public static final String ProfileIMAGE_UPLOAD_PATH = "/Users/taegyun/main project/sportmate/upload/profileImg/";
	public static final String ProfileIMAGE_EDIT_PATH = "/Users/taegyun/main project/sportmate/edit/profileImg/";
	public static final String StoryIMAGE_UPLOAD_PATH = "/Users/taegyun/main project/sportmate/upload/storyImg/";

	// 프로필 사진
	public static String saveProfileImgFile(int id, MultipartFile profileImage) {
		
		String directoryName = id + "_" + System.currentTimeMillis() + "/";
		
		String filePath = ProfileIMAGE_UPLOAD_PATH + directoryName;
		File directory = new File(filePath);
		
		if(directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes = profileImage.getBytes();
			Path path = Paths.get(filePath + profileImage.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + profileImage.getOriginalFilename();
	}
	
	// 프로필 수정 사진
	public static String editProfileImgFile(int userId, MultipartFile profileImage) {
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		String filePath = ProfileIMAGE_EDIT_PATH + directoryName;
		File directory = new File(filePath);
		
		if(directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes = profileImage.getBytes();
			Path path = Paths.get(filePath + profileImage.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + profileImage.getOriginalFilename();
	}
	
	// 스토리 사진
	public static String saveStoryImgFile(int userId, MultipartFile storyImage) {
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		String filePath = StoryIMAGE_UPLOAD_PATH + directoryName;
		File directory = new File(filePath);
		
		if(directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes = storyImage.getBytes();
			Path path = Paths.get(filePath + storyImage.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + storyImage.getOriginalFilename();
	}
	
	// 삭제
	public static boolean removeFile(String filePath) { //       /images/3_123141532121/test.png
		
		if(filePath == null) {
			return false;
		}
		
		String realProfileImageFilePath = ProfileIMAGE_UPLOAD_PATH + filePath.replace("/images/", "");
		String editProfileImageFilePath = ProfileIMAGE_EDIT_PATH + filePath.replace("/images/", "");
		String realStoryImageFilePath = StoryIMAGE_UPLOAD_PATH + filePath.replace("/images/", "");
		
		Path path = Paths.get(realProfileImageFilePath);
		Path path2 = Paths.get(editProfileImageFilePath);
		Path path3 = Paths.get(realStoryImageFilePath);
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		if(Files.exists(path2)) {
			try {
				Files.delete(path2);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		if(Files.exists(path3)) {
			try {
				Files.delete(path3);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		path = path.getParent();
		path2 = path2.getParent();
		path3 = path3.getParent();
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		if(Files.exists(path2)) {
			try {
				Files.delete(path2);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		if(Files.exists(path3)) {
			try {
				Files.delete(path3);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		return true;
	}
	
}
