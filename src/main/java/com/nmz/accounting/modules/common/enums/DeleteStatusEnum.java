package com.nmz.accounting.modules.common.enums;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-14:53
 */
public enum DeleteStatusEnum {

    DELETE_STATUS_NORMAL(0, "正常"),
    DELETE_STATUS_DELETE(1, "删除"),
    ;

    public static Optional<DeleteStatusEnum> getDeleteStatusByCode(Integer code) {
        return Arrays.stream(values())
                .filter(deleteStatusEnum -> deleteStatusEnum.getCode().equals(code))
                .findFirst();
    }

    private final Integer code;
    private final String desc;

    DeleteStatusEnum(Integer code, String desc) {
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
