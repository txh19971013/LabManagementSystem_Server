package com.txh.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@TableName("tb_course_schedule")
public class CourseScheduleEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 教室名称
     */
    private String classroomName;
    /**
     * 周数(第几周)
     */
    private Integer weekNum;
    /**
     * 星期(1-星期一，2-星期二...etc..)
     */
    private Integer week;
    /**
     * 时间(每天第几节课)
     */
    private Integer dayTimes;
    /**
     * 教师id
     */
    private Long teacherId;
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

    @Tolerate
    public CourseScheduleEntity() {
    }
}
