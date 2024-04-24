package com.example.libserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.User;
import com.example.libserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2023-11-24
 */
@RestController
@RequestMapping("/libserver/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("getUserList")
    public AjaxResult getUserList() {
        HashMap<String, Object> map = new HashMap<>();
        List<User> list = userService.list(null);
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @PostMapping("register")
    public AjaxResult register(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User one = userService.getOne(wrapper);
        if (one != null) {
            return AjaxResult.Error();
        }
        else {
            user.setType("1");
            userService.save(user);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user", user);
            return AjaxResult.Success(map);
        }
    }

    @PostMapping("login")
    public AjaxResult login(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        User one = userService.getOne(wrapper);
        if (one != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("user", one);
            return AjaxResult.Success(map);
        }
        else {
            return AjaxResult.Error();
        }
    }

    @PostMapping("getUserInfo")
    public AjaxResult getUserInfo(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        User one = userService.getOne(wrapper);
        if (one != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("user", one);
            return AjaxResult.Success(map);
        }
        else {
            return AjaxResult.Error();
        }
    }

}

