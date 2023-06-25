package com.fci.BlogApp.Services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fci.BlogApp.Services.PostService;
import com.fci.BlogApp.entities.Category;
import com.fci.BlogApp.entities.Post;
import com.fci.BlogApp.entities.User;
import com.fci.BlogApp.exception.ResourceNotFoundException;
import com.fci.BlogApp.payloads.PostDto;
import com.fci.BlogApp.repositories.CategoryRepo;
import com.fci.BlogApp.repositories.PostRepo;
import com.fci.BlogApp.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired  
	private ModelMapper modelMapper;
	 
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "User id", userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", " Category id", categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newpost= this.postRepo.save(post);
		
		return this.modelMapper.map(newpost, PostDto.class);
	}
 
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->
		new ResourceNotFoundException("Post", "post Id", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
			Post post = this.postRepo.findById(postId).orElseThrow(()->
			new ResourceNotFoundException("post", "post Id", postId));
			this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost(Integer pageNumber,Integer pageSize) {
//		int pageSize=5;
//		int pageNumber=2;
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost = this.postRepo.findAll(pageable);
		List<Post>allPosts=pagePost.getContent();
				
//		List<Post>allPosts=this.postRepo.findAll();
		List<PostDto>postDtos= allPosts.stream().map((post)-> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		 Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "post Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("categoryId", "category Id", categoryId));
//		List<Post>posts=this.postRepo.findByCategory(cat);
		List<Post>posts=this.postRepo.findByCategory(cat);
		
		List<PostDto>postDtos= posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		List<Post>posts=this.postRepo.findByUser(user);
		List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class))
		.collect(Collectors.toList());
		return postDtos;
		
	}

	@Override
	public List<Post> searchposts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}



}