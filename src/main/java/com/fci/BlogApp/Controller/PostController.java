package com.fci.BlogApp.Controller;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fci.BlogApp.Services.FileService;
import com.fci.BlogApp.Services.PostService;
import com.fci.BlogApp.config.AppConstants;
import com.fci.BlogApp.payloads.ApiResponse;
import com.fci.BlogApp.payloads.PostDto;
import com.fci.BlogApp.payloads.PostResponse;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;

	/**
	 * 
	 * @param postDto
	 * @param userId
	 * @param categoryId
	 * @return
	 */
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId
			)
	{
		PostDto createPost=this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	// get BY user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>>getPostByUser(@PathVariable Integer userId)
	{
		List<PostDto>posts=this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}

	// get by categeory 
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>>getPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto>posts=this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//Get all posts
	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param sortBy
	 * @param sortDir
	 * @return
	 */
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	 
	//get post details By Id
	/**
	 * 
	 * @param postId
	 * @return
	 */
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Integer postId)
	{
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK); 
	}
	
	// Delete post
	/**
	 * 
	 * @param postId
	 * @return
	 */
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		return new ApiResponse(" Post is Successfully deleted !!", true);
	}
	
	// Update post 
	/**
	 * 
	 * @param postDto
	 * @param postId
	 * @return
	 */
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	} 
	
	// Searching Data
	/**
	 * 
	 * @param keywords
	 * @return
	 */
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>>searchPostByTitle(
			@PathVariable("keywords") String keywords)
	{
		List<PostDto> results = this.postService.searchposts(keywords);
		return new ResponseEntity<List<PostDto>>(results,HttpStatus.OK);  
	}
	
//	Post Image upload
	/**
	 * 
	 * @param image
	 * @param postId
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/posts/image/upload/{postId}")
	public ResponseEntity<PostDto>uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable("postId") Integer postId
			) throws IOException
	{
		PostDto postDto = this.postService.getPostById(postId);
		String fileName= this.fileService.uploadImage(path,image);
		
		postDto.setImageName(fileName);
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param imageName
	 * @param response
	 */
	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) {
	    try (InputStream resource = this.fileService.getResource(path, imageName);
	         OutputStream outputStream = response.getOutputStream()) {

	        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	        byte[] buffer = new byte[4096]; // Adjust the buffer size as needed

	        int bytesRead;
	        while ((bytesRead = resource.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }

	    } catch (IOException e) {
	        // Handle the exception appropriately, e.g., log the error or return an error response.
	    }
	}

	
	
}
