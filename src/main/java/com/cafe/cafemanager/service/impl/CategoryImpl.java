package com.cafe.cafemanager.service.impl;

import com.cafe.cafemanager.module.CategoryEntity;
import com.cafe.cafemanager.repository.CategoryRepository;
import com.cafe.cafemanager.service.ICategory;
import com.cafe.cafemanager.service.converter.CategoryConverter;
import com.cafe.cafemanager.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl implements ICategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

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

        return categoryConverter.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO delete(Long id) {
        Optional<CategoryEntity> foundCategory = categoryRepository.findById(id);
        categoryRepository.delete(foundCategory.get());
        CategoryDTO categoryDTO = new CategoryDTO(foundCategory.get().getId(), foundCategory.get().getName());
        return categoryDTO;
    }
}
