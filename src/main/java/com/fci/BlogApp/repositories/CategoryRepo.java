package com.fci.BlogApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fci.BlogApp.entities.Category;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {

}
