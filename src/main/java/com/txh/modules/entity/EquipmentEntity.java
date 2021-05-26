package com.txh.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
     * 器材型号
     */
    private String type;
    /**
     * 器材数量
     */
    private Integer count;
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
