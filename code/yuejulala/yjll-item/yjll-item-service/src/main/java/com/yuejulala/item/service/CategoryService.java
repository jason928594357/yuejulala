package com.yuejulala.item.service;

import com.yuejulala.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoryListByPid(Long pid);

    void addCategory(Category category);
}
