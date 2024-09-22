/**
 * 
 */
package com.rajan.BlogApp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rajan.BlogApp.entities.User;
import com.rajan.BlogApp.exception.ResourceNotFoundException;
import com.rajan.BlogApp.repositories.UserRepo;

/**
 * @author Rajan.kumar
 *8:14:56 am
 *2023
 *BlogApp
 *TODO
 */
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "eamil : "+username, 0));
		
		return user;
	}

}
