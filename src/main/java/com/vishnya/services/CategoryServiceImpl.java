package com.vishnya.services;

import com.vishnya.dao.CategoryDao;
import com.vishnya.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long cId) {
        List<Object> list = new ArrayList<>();
        return categoryDao.findById(cId);
    }
}
