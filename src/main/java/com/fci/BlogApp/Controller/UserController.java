package com.fci.BlogApp.Controller;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fci.BlogApp.Services.UserService;
import com.fci.BlogApp.payloads.ApiResponse;
import com.fci.BlogApp.payloads.UserDto;

import jakarta.validation.Valid;

@RestController
//@Controller
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post - create user 
	@PostMapping("/create")
	public ResponseEntity<UserDto>createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto=this.userService.createUser(userDto);
 		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	//put -Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid)
	{
		UserDto updateduser=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updateduser);
		
	}
	// Delete - delete user
     	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid)
	{
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse> (new ApiResponse("User deleted successfully", true) ,HttpStatus.OK);
	}
	
	//Get -- user Get 
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllusers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	// Get -- Single user get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
	{
	return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
