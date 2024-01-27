package com.jjose.desafio.crud.services;

import com.jjose.desafio.crud.domain.category.Category;
import com.jjose.desafio.crud.domain.category.CategoryDTO;
import com.jjose.desafio.crud.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import com.jjose.desafio.crud.domain.category.exceptions.CategoryNotFoundException;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }
    public Category insert(CategoryDTO categotyDATA){
        Category newCategory = new Category();
        this.repository.save(newCategory);
        return newCategory;
    }
    public List<Category> getAll(){
        return this.repository.findAll();
    }
    public Category update(String id, CategoryDTO categoryData){
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());
        category.setTitle(categoryData.title());
        category.setDescription(categoryData.description());
        category.setOwnerId(categoryData.ownerId());
        this.repository.save(category);
        return category;
    }
}
