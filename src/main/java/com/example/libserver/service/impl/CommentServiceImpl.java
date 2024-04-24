package com.example.libserver.service.impl;

import com.example.libserver.entity.Comment;
import com.example.libserver.mapper.CommentMapper;
import com.example.libserver.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DXQ
 * @since 2023-12-07
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
