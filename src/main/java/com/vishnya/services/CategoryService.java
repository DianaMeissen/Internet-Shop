package com.vishnya.services;

import com.vishnya.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long cId);
}
