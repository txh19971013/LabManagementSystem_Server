/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.txh.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txh.modules.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    public UserEntity getUserByUsernameAndType(String username, Integer userType);
}
