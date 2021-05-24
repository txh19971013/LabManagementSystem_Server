package com.txh.modules.controller;

import cn.hutool.core.bean.BeanUtil;
import com.txh.common.utils.R;
import com.txh.modules.dto.UserDto;
import com.txh.modules.form.LoginForm;
import com.txh.modules.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Api(value = "用户信息接口", description = "用户信息接口")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("getAllTeachers")
    @ApiOperation("获取的教师数据")
    public R getAllTeachers() {
        return R.ok().put("teachers", userService.getAllTeachers().stream().map(t -> {
            UserDto userDto = new UserDto();
            BeanUtil.copyProperties(t, userDto);
            return userDto;
        }).collect(Collectors.toList()));
    }

    @PostMapping("login")
    @ApiOperation("用户登录")
    public R login(@RequestBody @Valid LoginForm loginForm) {
        return R.ok().put("user", userService.login(loginForm));
    }
}
