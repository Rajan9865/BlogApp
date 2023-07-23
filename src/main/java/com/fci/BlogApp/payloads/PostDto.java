package com.fci.BlogApp.payloads;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fci.BlogApp.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	private String title;
	
	private  String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
}
