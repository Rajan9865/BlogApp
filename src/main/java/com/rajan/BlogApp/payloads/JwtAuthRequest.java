/**
 * 
 */
package com.rajan.BlogApp.payloads;

import lombok.Data;

/**
 * @author deby7
 *6:29:30 am
 *2023
 *BlogApp
 *TODO
 */
@Data
public class JwtAuthRequest {

	private String username;
	
	private String password;
	
}
