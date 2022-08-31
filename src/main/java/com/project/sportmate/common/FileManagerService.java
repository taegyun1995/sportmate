package com.project.sportmate.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	public static final String ProfileIMAGE_UPLOAD_PATH = "/Users/taegyun/main project/sportmate/upload/profileImg/";

	public static String saveFile(String loginId, MultipartFile profileImage) {
		
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";
		
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

}
