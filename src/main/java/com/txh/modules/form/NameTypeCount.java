package com.txh.modules.form;

import lombok.Data;

/**
 * 根据申购记录的id，获取到申购的器材名、器材型号还有数量
 */
@Data
public class NameTypeCount {
    String name;
    String type;
    Integer count;
}
