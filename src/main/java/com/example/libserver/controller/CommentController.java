package com.example.libserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.*;
import com.example.libserver.service.ICommentService;
import com.example.libserver.service.INoteService;
import com.example.libserver.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
 * @since 2023-12-07
 */
@RestController
@RequestMapping("/libserver/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IUserService userService;

    @PostMapping("addComment")
    public AjaxResult addComment(@RequestBody Comment comment) {
        commentService.save(comment);

        return AjaxResult.Success();
    }

    @PostMapping("getCommentList")
    public AjaxResult getCommentList(@RequestBody Comment comment) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("book_id", comment.getBookId());
        List<Comment> list = commentService.list(wrapper);

        ArrayList<CommentInfoVo> infoVos = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CommentInfoVo commentInfoVo = new CommentInfoVo();
            BeanUtils.copyProperties(list.get(i),commentInfoVo);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("id", list.get(i).getUserId());
            User user = userService.getOne(userQueryWrapper);
            commentInfoVo.setUserName(user.getUsername());
            infoVos.add(commentInfoVo);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", infoVos);

        return AjaxResult.Success(map);
    }

    @PostMapping("deleteComment")
    public AjaxResult deleteComment(@RequestBody Comment comment) {
        commentService.removeById(comment.getId());

        return AjaxResult.Success();
    }
}

