/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.txh.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
    /**
     * 用户ID
     */
    @TableId
    private Long userId;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 用户类型(0-学生， 1-教师)
     */
    private Integer userType;
    /**
     * 性别(0-男，1-女)
     */
    private Integer sex;
    /**
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String major;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
