package com.vishnya.dao;

import com.vishnya.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findById(Long cId);
}
