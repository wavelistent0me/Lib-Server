package com.example.libserver.service.impl;

import com.example.libserver.entity.Favorite;
import com.example.libserver.mapper.FavoriteMapper;
import com.example.libserver.service.IFavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DXQ
 * @since 2024-02-01
 */
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements IFavoriteService {

}
