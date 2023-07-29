package com.fci.BlogApp.Services;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.List;

import com.fci.BlogApp.entities.Post;
import com.fci.BlogApp.payloads.PostDto;
import com.fci.BlogApp.payloads.PostResponse;

public interface PostService {
	//create
	PostDto createPost (PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String shortBy,String sortDir);
	
	//get single post
	 PostDto getPostById(Integer postId);
	 
	 //get all post by category
	 List<PostDto>getPostsByCategory(Integer categoryId);
	 
	 //get all posts by user
	 List<PostDto>getPostByUser(Integer userId);
	 
	 //Search posts
	 List<PostDto>searchposts(String keyword);
}
