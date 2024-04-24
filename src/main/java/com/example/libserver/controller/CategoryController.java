package com.example.libserver.controller;


import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.Category;
import com.example.libserver.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2024-02-01
 */
@RestController
@RequestMapping("/libserver/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("getCategoryList")
    public AjaxResult getCategoryList() {
        List<Category> list = categoryService.list(null);

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }
}

