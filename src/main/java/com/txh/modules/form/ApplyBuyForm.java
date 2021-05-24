package com.txh.modules.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "发起耗材申购的表单")
public class ApplyBuyForm {
    /**
     * 创建这条申请记录的教师的id
     */
    @ApiModelProperty(value = "教师id")
    @NotNull(message = "教师id不能为空")
    private long teacherId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String productName;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    @NotBlank(message = "商品编号不能为空")
    private String productNum;

    /**
     * 器材名称
     */
    @ApiModelProperty(value = "申请购买的耗材名称")
    @NotBlank(message = "耗材名称不能为空")
    private String name;

    /**
     * 器材型号
     */
    @ApiModelProperty(value = "器材型号")
    @NotBlank(message = "器材型号不能为空")
    private String type;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    @NotNull(message = "商品数量不能为空")
    private Integer count;

    /**
     * 商品参考价格
     */
    @ApiModelProperty(value = "商品参考单价")
    @NotNull(message = "参考单价不能为空")
    private double price;

    /**
     * 器材详情
     */
    @ApiModelProperty(value = "器材详情")
    @NotBlank(message = "器材详情不能为空")
    private String detail;

    /**
     * 总金额
     */
    @ApiModelProperty(value = "总金额")
    @NotNull(message = "总金额不能为空")
    private double totalMoney;
}
