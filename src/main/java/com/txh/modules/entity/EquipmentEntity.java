package com.txh.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jasun on 2021/5/7 22:36.
 */
@Data
@TableName("tb_equipment")
public class EquipmentEntity implements Serializable {
    @TableId
    private Long id;
    /**
     * 器材名称
     */
    private String name;
    /**
     * 采购时间
     */
    private Date buyDate;
    /**
     * 状态(0-未借出， 1-已借出未归还)
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
