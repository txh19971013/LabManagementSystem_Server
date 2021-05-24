package com.txh.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txh.modules.dao.CourseScheduleDao;
import com.txh.modules.dto.CourseScheduleDto;
import com.txh.modules.entity.CourseScheduleEntity;
import com.txh.modules.form.AddCourseForm;
import com.txh.modules.service.CourseScheduleService;
import com.txh.modules.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseScheduleServiceImpl extends ServiceImpl<CourseScheduleDao, CourseScheduleEntity> implements CourseScheduleService {
    @Resource
    private UserService userService;

//    @Override
//    public CourseScheduleDto saveCourse(CourseScheduleForm courseScheduleForm) {
//        UserEntity userEntity = userService.getById(courseScheduleForm.getTeacherId());
//        if (userEntity == null || userEntity.getUserType() == 0) {
//            throw new RRException("教师不存在");
//        }
//
//        CourseScheduleEntity courseScheduleEntity = new CourseScheduleEntity();
//        BeanUtil.copyProperties(courseScheduleForm, courseScheduleEntity);//把参数复制给实体类
//        courseScheduleEntity.setCreateTime(new Date());
//        courseScheduleEntity.setUpdateTime(new Date());
//        baseMapper.insert(courseScheduleEntity);
//
//        CourseScheduleDto courseScheduleDto = new CourseScheduleDto();
//        BeanUtil.copyProperties(courseScheduleEntity, courseScheduleDto);
//        courseScheduleDto.setUsername(userEntity.getUsername());
//        return courseScheduleDto;
//    }

    @Override
    public List<CourseScheduleDto> getAllCourse(Integer week_num, String classroom_name) {
        return baseMapper.getAllCourse(week_num, classroom_name);
    }

    @Override
    public Integer addCourse(AddCourseForm addCourseForm) {
        return baseMapper.addCourse(addCourseForm);
    }
}
