package com.txh.modules.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CourseScheduleDto implements Serializable {
    /**
     * 周数(第几周)
     */
    private Integer weekNum;
    /**
     * 时间(每天第几节课)
     */
    private Integer dayTimes;
    /**
     * 星期(1-星期一，2-星期二...etc..)
     */
    private Integer week;
    /**
     * 教师id
     */
    private Long teacherId;
    /**
     * 教室名称
     */
    private String classroomName;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 用户名
     */
    private String username;
    /**
     * 老师真实名称
     */
    private String realname;
}
