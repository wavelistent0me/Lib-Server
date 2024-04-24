package com.example.libserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.*;
import com.example.libserver.service.IBookService;
import com.example.libserver.service.IFavoriteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2024-02-01
 */
@RestController
@RequestMapping("/libserver/favorite")
public class FavoriteController {

    @Autowired
    private IFavoriteService favoriteService;
    @Autowired
    private IBookService bookService;

    @PostMapping("isFavorite")
    public AjaxResult isFavorite(@RequestBody Favorite favorite) {

        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", favorite.getUserId());
        wrapper.eq("book_id", favorite.getBookId());
        HashMap<String, Object> map = new HashMap<>();
        if (favoriteService.getOne(wrapper) == null) {
            map.put("isFavorite", 0);
        }
        else {
            map.put("isFavorite", 1);
        }

        return AjaxResult.Success(map);
    }

    @PostMapping("setFavorite")
    public AjaxResult setFavorite(@RequestBody Favorite favorite) {

        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", favorite.getUserId());
        wrapper.eq("book_id", favorite.getBookId());
        HashMap<String, Object> map = new HashMap<>();
        if (favoriteService.getOne(wrapper) == null) {
            favoriteService.save(favorite);
            map.put("isFavorite", 1);
        }
        else {
            favoriteService.removeById(favoriteService.getOne(wrapper));
            map.put("isFavorite", 0);
        }

        return AjaxResult.Success(map);
    }

    @GetMapping("getFavoriteList")
    public AjaxResult getFavoriteList(@RequestParam String userId) {

        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);

        List<Favorite> list = favoriteService.list(wrapper);

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

