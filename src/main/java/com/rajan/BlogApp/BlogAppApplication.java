package com.rajan.BlogApp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.LogSF;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rajan.BlogApp.config.AppConstants;
import com.rajan.BlogApp.entities.Role;
import com.rajan.BlogApp.repositories.RoleRepo;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
@Slf4j
@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

//			List<Role> roles = List.of(role, role1);
//			List<Role>roles=Arrays.asList(role,role1);
			List<Role>roles=Stream.of(role,role1).collect(Collectors.toList());

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
//				System.out.println(r.getName());
				log.info("get name {}",r.getName());
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
