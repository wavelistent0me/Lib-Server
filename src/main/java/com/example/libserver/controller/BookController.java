package com.example.libserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.Book;
import com.example.libserver.entity.BookLike;
import com.example.libserver.entity.Category;
import com.example.libserver.entity.User;
import com.example.libserver.service.IBookService;
import com.example.libserver.service.ICategoryService;
import com.example.libserver.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2023-11-24
 */
@RestController
@RequestMapping("/libserver/book")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ILikeService likeService;

    @GetMapping("getBookList")
    public AjaxResult getBookList() {
        List<Book> list = bookService.list(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @PostMapping("searchBookList")
    public AjaxResult searchBookList(@RequestBody Book book) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name", book.getName());
        List<Book> list = bookService.list(wrapper);

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @GetMapping("getRankBook")
    public AjaxResult getRankBook() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("view");
        List<Book> list = bookService.list(wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @PostMapping("addBook")
    public AjaxResult addBook(@RequestBody Book book) {

        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("name", book.getCategory());
        Category category = categoryService.getOne(wrapper);
        if (category != null) {
            book.setCategoryId(category.getId());
        }
        else {
            category = new Category();
            category.setName(book.getCategory());
            categoryService.save(category);
            book.setCategoryId(category.getId());
        }

        bookService.save(book);

        return AjaxResult.Success();
    }

    @PostMapping("getBookInfo")
    public AjaxResult getBookInfo(@RequestBody Book book) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("id", book.getId());
        Book one = bookService.getOne(wrapper);

        one.setCategory(bookService.getCategory(one.getCategoryId()));
        QueryWrapper<BookLike> wrapperBookLike = new QueryWrapper<>();
        wrapperBookLike.eq("book_id", book.getId());
        one.setLikeNum(likeService.count(wrapperBookLike));

        HashMap<String, Object> map = new HashMap<>();
        map.put("info", one);

        return AjaxResult.Success(map);
    }

    @PostMapping("editBook")
    public AjaxResult editBook(@RequestBody Book book) {
        bookService.updateById(book);

        return AjaxResult.Success();
    }

    @PostMapping("deleteBook")
    public AjaxResult deleteBook(@RequestBody Book book) {
        bookService.removeById(book.getId());

        return AjaxResult.Success();
    }

    @PostMapping("addView")
    public AjaxResult addView(@RequestBody Book book) {
        Book one = bookService.getById(book);
        int view = one.getView();
        view++;
        one.setView(view);
        bookService.updateById(one);

        return AjaxResult.Success();
    }

    @PostMapping("setRecommend")
    public AjaxResult setRecommend(@RequestBody Book book) {
        Book one = bookService.getById(book);
        if (one.getIsRecommend() == 1) {
            one.setIsRecommend(0);
        }
        else {
            one.setIsRecommend(1);
        }
        bookService.updateById(one);

        return AjaxResult.Success();
    }

    @GetMapping("getRecommendList")
    public AjaxResult getRecommendList() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("is_recommend", 1);
        List<Book> list = bookService.list(wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @PostMapping("getBookListByCategoryId")
    public AjaxResult getBookListByCategoryId(@RequestBody Book book) {

        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", book.getCategoryId());
        List<Book> list = bookService.list(wrapper);

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @GetMapping("getLikeRankList")
    public AjaxResult getLikeRankList() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("like_num");
        List<Book> list = bookService.list(wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }
}

