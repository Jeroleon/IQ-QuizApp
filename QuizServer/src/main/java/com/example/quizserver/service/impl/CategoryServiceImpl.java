package com.example.quizserver.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizserver.entity.quiz.Category;
import com.example.quizserver.repository.CategoryRepository;
import com.example.quizserver.service.CategoryService;



@Service()
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public void deleteCategory(Long cid) throws Exception {
		this.categoryRepository.deleteById(cid);

	}

	@Override
	public Category getCategoryById(Long cid) throws Exception {
		Category category=this.categoryRepository.findById(cid).get();
		System.out.println("category data fetch from db is "+category.getTitle()+" "+category.getDescription()+" "+category.getCid());
		return category;
	}

}