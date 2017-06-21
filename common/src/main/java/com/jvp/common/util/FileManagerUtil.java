package com.jvp.common.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerUtil {

	static String filePath;

	public static String saveFile(MultipartFile file) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\\MM\\dd\\");
		String dateString = simpleDateFormat.format(new Date());
		Long dateLong = new Date().getTime();
		String fileUrl = null;
		if (file != null) {
			String myFileName = file.getOriginalFilename();
			if (myFileName.trim() != "") {
				String prefix = myFileName.substring(myFileName
						.lastIndexOf("."));
				String fileName = dateLong + prefix;
				String path = filePath + dateString;
				File localFile = new File(path);
				if (!localFile.exists() && !localFile.isDirectory()) {
					localFile.mkdirs();
				}
				localFile = new File(path + fileName);
				try {
					file.transferTo(localFile);
					fileUrl = path + fileName;
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileUrl;
	}
	
	public static File readFile(String path){
		File file = new File(path);
		return file;
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileManagerUtil.filePath = filePath;
	}
	
	
}