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
        if(CollectionUtils.isEmpty(list)){
            throw new YjllException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }
}