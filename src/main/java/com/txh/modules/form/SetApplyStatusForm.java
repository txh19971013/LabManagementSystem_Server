package com.txh.modules.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "管理员审核耗材申请的表单")
public class SetApplyStatusForm {
    /**
     * 该条记录的id
     */
    @ApiModelProperty(value = "这条申请记录的id")
    @NotNull(message = "记录id参数不能为空")
    private Long id;
    /**in
     * 状态(0-审核中， 1-已通过， 2-已拒绝)
     */
    @ApiModelProperty(value = "审核状态0-审核中， 1-已通过， 2-已拒绝，只能传1或2")
    @NotNull(message = "审核状态参数不能为空")
    @Range(min = 1, max = 2, message = "审核状态参数必须是1或2")
    private Integer buyStatus;
}
