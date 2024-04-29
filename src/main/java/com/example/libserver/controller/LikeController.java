package com.example.libserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.Book;
import com.example.libserver.entity.BookLike;
import com.example.libserver.entity.Favorite;
import com.example.libserver.service.IBookService;
import com.example.libserver.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2024-04-29
 */
@RestController
@RequestMapping("/libserver/like")
public class LikeController {

    @Autowired
    private ILikeService likeService;
    @Autowired
    private IBookService bookService;

    @PostMapping("isLike")
    public AjaxResult isFavorite(@RequestBody BookLike bookLike) {

        QueryWrapper<BookLike> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", bookLike.getUserId());
        wrapper.eq("book_id", bookLike.getBookId());
        HashMap<String, Object> map = new HashMap<>();
        if (likeService.getOne(wrapper) == null) {
            map.put("isLike", 0);
        }
        else {
            map.put("isLike", 1);
        }

        return AjaxResult.Success(map);
    }

    @PostMapping("setLike")
    public AjaxResult setLike(@RequestBody BookLike bookLike) {

        QueryWrapper<BookLike> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", bookLike.getUserId());
        wrapper.eq("book_id", bookLike.getBookId());
        HashMap<String, Object> map = new HashMap<>();

        Book book = bookService.getById(bookLike.getBookId());

        if (likeService.getOne(wrapper) == null) {
            likeService.save(bookLike);
            map.put("isLike", 1);
            book.setLikeNum(book.getLikeNum() + 1);
        }
        else {
            likeService.removeById(likeService.getOne(wrapper));
            map.put("isLike", 0);
            book.setLikeNum(book.getLikeNum() - 1);
        }
        bookService.updateById(book);

        return AjaxResult.Success(map);
    }

    @GetMapping("getMyLikeList")
    public AjaxResult getMyLikeList(@RequestParam String userId) {

        QueryWrapper<BookLike> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);

        List<BookLike> list = likeService.list(wrapper);

        List<Book> bookList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Book book = bookService.getById(list.get(i).getBookId());
            bookList.add(book);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("bookList", bookList);

        return AjaxResult.Success(map);
    }
}

