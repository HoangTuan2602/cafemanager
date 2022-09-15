package com.cafe.cafemanager.service.impl;

import com.cafe.cafemanager.module.CategoryEntity;
import com.cafe.cafemanager.repository.CategoryRepository;
import com.cafe.cafemanager.service.ICategory;
import com.cafe.cafemanager.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl implements ICategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO newCategoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (newCategoryDTO.getId() != null) {
            Optional<CategoryEntity> foundCategory = categoryRepository.findById(newCategoryDTO.getId());
            categoryEntity = foundCategory.get();
            categoryEntity.setName(newCategoryDTO.getName());
        }
        else {
            categoryEntity.setName(newCategoryDTO.getName());
        }

        categoryRepository.save(categoryEntity);

        CategoryDTO categoryDTO = new CategoryDTO(categoryEntity.getId(), categoryEntity.getName());
        return categoryDTO;
    }

    @Override
    public CategoryDTO delete(Long id) {
        Optional<CategoryEntity> foundCategory = categoryRepository.findById(id);
        categoryRepository.delete(foundCategory.get());
        CategoryDTO categoryDTO = new CategoryDTO(foundCategory.get().getId(), foundCategory.get().getName());
        return categoryDTO;
    }
}
