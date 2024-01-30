package com.jjose.desafio.crud.services;

import com.jjose.desafio.crud.domain.category.Category;
import com.jjose.desafio.crud.domain.category.CategoryDTO;
import com.jjose.desafio.crud.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import com.jjose.desafio.crud.domain.category.exceptions.CategoryNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Category insert(CategoryDTO categotyDATA){
        Category newCategory = new Category();
        this.repository.save(newCategory);
        return newCategory;
    }

    @GetMapping("/{id}")
    public List<Category> getAll(){
        return this.repository.findAll();
    }

    @PutMapping("/{id}")
    public Category update(String id, CategoryDTO categoryData){
        Category category = this.repository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());
        category.setTitle(categoryData.title());
        category.setDescription(categoryData.description());
        category.setOwnerId(categoryData.ownerId());
        this.repository.save(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public void delete(String id){
        Category category = this.repository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        this.repository.delete(category);
    }
}