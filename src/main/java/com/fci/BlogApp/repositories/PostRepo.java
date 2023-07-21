package com.fci.BlogApp.repositories;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fci.BlogApp.entities.Category;
import com.fci.BlogApp.entities.Post;
import com.fci.BlogApp.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Category category);
	
	List<Post> findByUser(User user);
	
	List<Post>findByTitleContaining(String title);

}
 