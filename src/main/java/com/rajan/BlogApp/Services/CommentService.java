/**
 * 
 */
package com.rajan.BlogApp.Services;

import com.rajan.BlogApp.payloads.CommentDto;

/**
 * @author deby7
 *6:35:19 am
 *2023
 *BlogApp
 *TODO
 */

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer postId);
	
	void deleteComment(Integer commentId);
}
