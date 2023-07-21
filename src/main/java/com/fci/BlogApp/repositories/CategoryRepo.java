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

public interface CategoryRepo  extends JpaRepository<Category, Integer> {
//	List<Post>findByUser (User user);
//	List<Post>findByCategory(Category category);
} 