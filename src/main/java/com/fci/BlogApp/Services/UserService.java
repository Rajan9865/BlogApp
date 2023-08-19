package com.fci.BlogApp.Services;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.List;

import com.fci.BlogApp.payloads.UserDto;

public interface UserService {
	
	UserDto registerNewUser(UserDto user);
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user , Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUsers();
	void deleteUser(Integer userId);
}
