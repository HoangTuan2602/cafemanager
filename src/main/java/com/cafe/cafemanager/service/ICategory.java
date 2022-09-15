package com.cafe.cafemanager.service;

import com.cafe.cafemanager.service.dto.CategoryDTO;

public interface ICategory {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO delete(Long id);
}
