package com.nmz.accounting.modules.common.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description: 公用是否枚举
 * @Author: 聂明智
 * @Date: 2024/4/12-16:10
 */
public enum YesNoEnum {
    NO(0, "否"),
    YES(1, "是"),
    ;

    final Integer code;
    final String desc;

    public static Optional<YesNoEnum> getEnumByCode(Integer code) {
        return Arrays.stream(values())
                    .filter(e -> e.code.equals(code))
                    .findFirst();
    }

    YesNoEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
