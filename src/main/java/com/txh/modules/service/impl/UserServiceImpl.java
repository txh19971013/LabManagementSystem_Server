/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.txh.modules.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txh.common.exception.RRException;
import com.txh.common.validator.Assert;
import com.txh.modules.dao.UserDao;
import com.txh.modules.dto.UserDto;
import com.txh.modules.entity.UserEntity;
import com.txh.modules.form.LoginForm;
import com.txh.modules.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public List<UserEntity> getAllTeachers() {
        return baseMapper.selectList(new QueryWrapper<UserEntity>().eq("user_type", 1));
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
    }

    @Override
    public UserDto login(LoginForm form) {
        UserEntity user = baseMapper.getUserByUsernameAndType(form.getUsername(), form.getUserType());
        Assert.isNull(user, "用户不存在");//user为null则用户不存在

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {//DigestUtils.sha256Hex进行MD5加密
            throw new RRException("用户名或密码错误");
        }

        UserDto userDto = new UserDto();
        BeanUtil.copyProperties(user, userDto);
        return userDto;
    }
}
