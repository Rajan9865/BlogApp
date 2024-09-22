package com.rajan.BlogApp.Services.impl;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rajan.BlogApp.Services.FileService;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) {
		//file Name 
		String name=file.getOriginalFilename();
//		abc.png
		
		// Random Name Generate File
		String randomId=UUID.randomUUID().toString();
		String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//Full Path
		String filepath=path+File.separatorChar+fileName1;
		
		// create folder if not created
		File f=new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		
//		 file copy
		try {
			Files.copy(file.getInputStream(), Paths.get(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String filename) {
		String fullPath=path+File.separator+filename;
		InputStream is = null;
		try {
			is = new FileInputStream(fullPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		return is;
	}
 
}
