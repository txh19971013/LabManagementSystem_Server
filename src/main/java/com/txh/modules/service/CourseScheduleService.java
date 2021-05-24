package com.txh.modules.service;


import com.txh.modules.dto.CourseScheduleDto;
import com.txh.modules.form.AddCourseForm;

import java.util.List;

public interface CourseScheduleService {

    public List<CourseScheduleDto> getAllCourse(Integer week_num, String classroom_name);

    public Integer addCourse(AddCourseForm addCourseForm);
}
