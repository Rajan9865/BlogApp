/**
 * 
 */
package com.rajan.BlogApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.BlogApp.Services.CommentService;
import com.rajan.BlogApp.payloads.ApiResponse;
import com.rajan.BlogApp.payloads.CommentDto;

/**
 * @author deby7
 *7:56:19 am
 *2023
 *BlogApp
 *TODO
 */
@RestController
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 
	 * @param comment
	 * @param postId
	 * @return
	 */
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto comment,@PathVariable Integer postId)
	{
		CommentDto createComment=this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param commentId
	 * @return
	 */
	 @DeleteMapping("/comments/{commentId}")
	 public ResponseEntity<ApiResponse> deleteComent(@PathVariable Integer commentId)
	 {
		 this.commentService.deleteComment(commentId);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("comment Deleted Successfuly",!! true), HttpStatus.OK);
	 }
}
