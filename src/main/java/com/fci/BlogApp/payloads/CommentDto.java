/**
 * 
 */
package com.fci.BlogApp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author deby7
 *6:28:51 am
 *2023
 *BlogApp
 *TODO
 */
  
@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
	private int id;
	
	private String content;
}
