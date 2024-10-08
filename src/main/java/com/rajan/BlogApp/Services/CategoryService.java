package com.rajan.BlogApp.Services;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.List;

import com.rajan.BlogApp.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
//	CategoryDto deleteCategory();
	void deleteCategory(Integer categoryId);
	
	//get single user
	CategoryDto getCategory(Integer categoryId);
	
	//Get all users
	List<CategoryDto>getcategories();

}
