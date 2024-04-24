package com.example.libserver.service.impl;

import com.example.libserver.entity.User;
import com.example.libserver.mapper.UserMapper;
import com.example.libserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
