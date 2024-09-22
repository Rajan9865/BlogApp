/**
 * 
 */
package com.rajan.BlogApp.payloads;

/**
 * @author deby7
 *8:02:49 am
 *2023
 *BlogApp
 *TODO
 */
import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
}