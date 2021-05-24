package com.txh.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txh.modules.dto.CourseScheduleDto;
import com.txh.modules.entity.CourseScheduleEntity;
import com.txh.modules.form.AddCourseForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseScheduleDao extends BaseMapper<CourseScheduleEntity> {
    //返回XX周XX实验室的实验室使用情况列表
    public List<CourseScheduleDto> getAllCourse(Integer week_num, String classroom_name);
    //新增空闲实验室占用
    public Integer addCourse(AddCourseForm addCourseForm);
}
