package com.txh.modules.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "添加课程的表单")
public class AddCourseForm {
    /**
     * 教室名称
     */
    @ApiModelProperty(value = "实验室名字（如：101）")
    @NotNull(message = "实验室不能为空")
    @NotBlank(message = "实验室不能为空")
    private String classroomName;
    /**
     * 周数(第几周)
     */
    @ApiModelProperty(value = "周数（如：第一周）")
    @NotNull(message = "周数不能为空")
    @NotBlank(message = "周数不能为空")
    private Integer weekNum;
    /**
     * 星期(1-星期一，2-星期二...etc..)
     */
    @ApiModelProperty(value = "星期几（如：1-星期一，2-星期二...）")
    @NotNull(message = "星期几不能为空")
    @NotBlank(message = "星期几不能为空")
    private Integer week;
    /**
     * 时间(每天第几节课)
     */
    @ApiModelProperty(value = "第几节课（如：第一节课）")
    @NotNull(message = "第几节课不能为空")
    @NotBlank(message = "第几节课不能为空")
    private Integer dayTimes;
    /**
     * 教师id
     */
    @ApiModelProperty(value = "教师id")
    @NotNull(message = "教师id不能为空")
    @NotBlank(message = "教师id不能为空")
    private Long teacherId;
    /**
     * 课程名称
     */
    @ApiModelProperty(value = "课程名")
    @NotBlank(message = "课程名不能为空")
    @NotNull(message = "课程名不能为空")
    private String courseName;
}
