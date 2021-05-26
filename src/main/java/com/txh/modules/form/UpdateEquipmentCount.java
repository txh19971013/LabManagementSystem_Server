package com.txh.modules.form;

import lombok.Data;

/**
 * 根据name和type更改count
 */
@Data
public class UpdateEquipmentCount {
    Integer count;
    String name;
    String type;
}
