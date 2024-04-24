package com.example.libserver.service.impl;

import com.example.libserver.entity.Book;
import com.example.libserver.mapper.BookMapper;
import com.example.libserver.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.libserver.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DXQ
 * @since 2023-11-24
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private ICategoryService categoryService;

    @Override
    public String getCategory(String categoryId) {
        return categoryService.getById(categoryId).getName();
    }
}
