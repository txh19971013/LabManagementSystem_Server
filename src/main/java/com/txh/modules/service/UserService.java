/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.txh.modules.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.txh.modules.dto.UserDto;
import com.txh.modules.entity.UserEntity;
import com.txh.modules.form.LoginForm;

import java.util.List;

public interface UserService extends IService<UserEntity> {
    public List<UserEntity> getAllTeachers();

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     *
     * @param form 登录表单
     * @return 返回用户ID
     */
    public UserDto login(LoginForm form);
}
