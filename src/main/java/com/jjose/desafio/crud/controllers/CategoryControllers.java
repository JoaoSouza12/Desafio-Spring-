package com.jjose.desafio.crud.controllers;

import com.jjose.desafio.crud.domain.category.Category;
import com.jjose.desafio.crud.domain.category.CategoryDTO;
import com.jjose.desafio.crud.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryControllers {
    private CategoryService service;
    public CategoryControllers(CategoryService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categotyData) {
        Category newCategory = this.service.insert(categotyData);
        return ResponseEntity.ok().body(newCategory);
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }
    public ResponseEntity<Category> delete(@PathVariable String id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } }
