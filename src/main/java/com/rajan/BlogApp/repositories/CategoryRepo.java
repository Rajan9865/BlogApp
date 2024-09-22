package com.rajan.BlogApp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rajan.BlogApp.entities.Category;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {
//	List<Post>findByUser (User user);
//	List<Post>findByCategory(Category category);
} 