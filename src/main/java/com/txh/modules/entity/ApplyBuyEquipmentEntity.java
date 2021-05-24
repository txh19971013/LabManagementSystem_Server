package com.txh.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_equipment_buy")
public class ApplyBuyEquipmentEntity {//教师耗材申请记录
    /**
     * 主键id
     */
    @TableId
    private long id;
    /**
     * 创建这条申请记录的教师的id
     */
    private long teacherId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品编号
     */
    private String productNum;
    /**
     * 器材名称
     */
    private String name;
    /**
     * 器材型号
     */
    private String type;
    /**
     * 商品数量
     */
    private Integer count;
    /**
     * 商品参考价格
     */
    private Double price;
    /**
     * 器材详情
     */
    private String detail;
    /**
     * 总金额
     */
    private Double totalMoney;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态(0-审核中， 1-已通过， 2-已拒绝)
     */
    private Integer buyStatus;
}
