package com.yuejulala.item.service.impl;

import com.yuejulala.common.enums.ExceptionEnum;
import com.yuejulala.common.exception.YjllException;
import com.yuejulala.item.dao.CategoryMapper;
import com.yuejulala.item.pojo.Category;
import com.yuejulala.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryListByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> list = categoryMapper.select(category);
        return list;
    }

    @Override
    public void addCategory(Category category) {
        int count = categoryMapper.updateByPrimaryKeySelective(category);
        if (count == 1) {
            return;
        }
        count = categoryMapper.insert(category);
        if (count == 0) {
            throw new YjllException(ExceptionEnum.CATEGORY_SAVE_ERROR);
        }
    }
}