package com.rajan.BlogApp.Services;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.List;

import com.rajan.BlogApp.payloads.UserDto;

public interface UserService {
	
	UserDto registerNewUser(UserDto user);
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user , Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUsers();
	void deleteUser(Integer userId);
}
