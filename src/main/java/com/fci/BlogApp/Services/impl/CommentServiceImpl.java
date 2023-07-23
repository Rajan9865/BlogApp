/**
 * 
 */
package com.fci.BlogApp.Services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fci.BlogApp.Services.CommentService;
import com.fci.BlogApp.entities.Comment;
import com.fci.BlogApp.entities.Post;
import com.fci.BlogApp.exception.ResourceNotFoundException;
import com.fci.BlogApp.payloads.CommentDto;
import com.fci.BlogApp.repositories.CommentRepo;
import com.fci.BlogApp.repositories.PostRepo;

/**
 * @author deby7
 *7:36:44 am
 *2023
 *BlogApp
 *TODO
 */
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo; 
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new 
				ResourceNotFoundException("Post", "postId", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment saveddComment = this.commentRepo.save(comment);
		return this.modelMapper.map(saveddComment, CommentDto.class);
	}

	
	@Override
	public void deleteComment(Integer commentId) {
		Comment comm = this.commentRepo.findById(commentId).orElseThrow(()-> 
		new ResourceNotFoundException("Comment", "commentId", commentId));
		this.commentRepo.delete(comm);
	}

}
