package com.txh.modules.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "排课表单")
public class CourseScheduleForm implements Serializable {
    /**
     * 周数(第几周)
     */
    @ApiModelProperty(value = "周数(第几周)")
    @NotNull(message = "上课周数不能为空")
    private Integer weekNum;
    /**
     * 时间(每天第几节课)
     */
    @ApiModelProperty(value = "")
    @NotNull(message = "时间(每天第几节课)")
    private Integer dayTimes;
    /**
     * 星期(1-星期一，2-星期二...etc..)
     */
    @ApiModelProperty(value = "星期(1-星期一，2-星期二...etc..)")
    @NotNull(message = "星期不能为空")
    private Integer week;
    /**
     * 教师id
     */
    @ApiModelProperty(value = "教师id")
    @NotNull(message = "上课老师不能为空")
    private Long teacherId;
    /**
     * 教室名称
     */
    @ApiModelProperty(value = "教室名称")
    @NotBlank(message = "教室名称不能为空")
    private String classroomName;
    /**
     * 课程名称
     */
    @ApiModelProperty(value = "课程名称")
    @NotBlank(message = "课程名称不能为空")
    private String courseName;
}
