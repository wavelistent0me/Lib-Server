package com.example.libserver.service;

import com.example.libserver.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DXQ
 * @since 2023-11-24
 */
public interface IBookService extends IService<Book> {

    //查询类别名称 写个方法复用
    String getCategory(String categoryId);
}
