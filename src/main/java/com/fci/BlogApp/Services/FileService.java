package com.fci.BlogApp.Services;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String uploadImage(String path,MultipartFile file);
	InputStream getResource(String path,String filename);  

}
