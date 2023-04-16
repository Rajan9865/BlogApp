package com.fci.BlogApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fci.BlogApp.repositories.UserRepo;

@SpringBootTest
class BlogAppApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void repoTest()
	{
		String ClassName =this.userRepo.getClass().getName();
		String packName=this.userRepo.getClass().getPackageName();
		System.out.println(ClassName);
		System.out.println(packName);
	}

}	
