package com.example.libserver.service.impl;

import com.example.libserver.entity.BookLike;
import com.example.libserver.mapper.LikeMapper;
import com.example.libserver.service.ILikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DXQ
 * @since 2024-04-29
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, BookLike> implements ILikeService {

}
