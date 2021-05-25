package com.txh.modules.controller;

import com.txh.common.utils.R;
import com.txh.modules.form.AddCourseForm;
import com.txh.modules.service.CourseScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/course")
@Api(value = "实验室排课接口", description = "实验室排课接口")
public class CourseScheduleController {
    @Resource
    private CourseScheduleService courseScheduleService;

    @GetMapping("getAllCourse")
    @ApiOperation("获取XX周XX教室所有的课程")
    public R getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer week_num, @RequestParam(required = false, defaultValue = "101")String classroom_name) {
        return R.ok("查询成功").put("course", courseScheduleService.getAllCourse(week_num, classroom_name));
    }

    @PostMapping("saveCourse")
    @ApiOperation("在空闲实验室进行排课")
    public R saveCourse(@RequestBody @Valid AddCourseForm addCourseForm) {
        if (courseScheduleService.addCourse(addCourseForm) == 1) {
            return R.ok("排课成功");
        } else {
            return R.error("该实验室已被占用");
        }
    }
}
