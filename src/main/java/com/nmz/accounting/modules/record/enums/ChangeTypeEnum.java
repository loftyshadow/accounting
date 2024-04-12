package com.nmz.accounting.modules.record.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-15:51
 */
public enum ChangeTypeEnum {

    RECORD_TYPE_INCOME(0, "收入"),
    RECORD_TYPE_EXPENDITURE(1, "支出"),
    ;

    final Integer code;
    final String desc;

    public static Optional<ChangeTypeEnum> getEnumByCode(Integer code) {
        return Arrays.stream(values())
                    .filter(e -> e.code.equals(code))
                    .findFirst();
    }

    ChangeTypeEnum(Integer code, String desc) {
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
