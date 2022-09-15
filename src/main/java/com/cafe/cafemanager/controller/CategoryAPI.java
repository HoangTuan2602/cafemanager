package com.cafe.cafemanager.controller;

import com.cafe.cafemanager.service.dto.CategoryDTO;
import com.cafe.cafemanager.service.impl.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryAPI {
    @Autowired
    private CategoryImpl category;

    @PostMapping(value = "/category")
    public CategoryDTO newCategory(@RequestBody CategoryDTO categoryDTO) {
        return category.save(categoryDTO);
    }

    @PutMapping(value = "/category")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return category.save(categoryDTO);
    }

    @DeleteMapping(value = "/category/{id}")
    public CategoryDTO deleteCategory(@PathVariable Long id) {
        return category.delete(id);
    }
}
