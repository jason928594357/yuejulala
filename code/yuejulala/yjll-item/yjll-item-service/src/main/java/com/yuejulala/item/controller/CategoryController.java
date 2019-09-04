package com.yuejulala.item.controller;

import com.yuejulala.item.pojo.Category;
import com.yuejulala.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点id查询商品分类
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByPid(@RequestParam("pid") Long pid){
        return ResponseEntity.ok(categoryService.queryCategoryListByPid(pid));
    }

    /**
     * 新增商品分类
     * @param category
     * @return
     */
    @PostMapping("save")
    public ResponseEntity<Void> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}