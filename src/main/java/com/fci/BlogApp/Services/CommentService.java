/**
 * 
 */
package com.fci.BlogApp.Services;

import com.fci.BlogApp.payloads.CommentDto;

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
