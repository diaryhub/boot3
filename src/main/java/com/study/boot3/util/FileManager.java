package com.study.boot3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public String fileSave(MultipartFile mf,String path) throws Exception{
		//path = "프로젝트 상의 파일을 저장할 폴더의 경로"
		//1. 파일을 HDD에 저장하고
		//2. 저장된 파일명을 리턴(파일명은 중복 X)
		String realPath=servletContext.getRealPath(path);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
				
				String fileName = UUID.randomUUID().toString();
				String oriName = mf.getOriginalFilename();
				System.out.println("UUID: "+fileName);
				fileName = fileName +"_"+oriName;
				
//				file = new File(realPath, fileName);
				file = new File(file,fileName);
				mf.transferTo(file);				
		
		
		return fileName;
	}
	
	public boolean remove(String path,String fileName) throws Exception{
		path = servletContext.getRealPath(path);
		File file = new File(path,fileName);
		return file.delete();
	}
	
}
