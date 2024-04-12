package com.nmz.accounting.modules.record.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-16:50
 */
public enum RecordStatus {
    RECORD_STATUS_PENDING(0, "处理中"),
    RECORD_STATUS_SUCCESS(1, "成功"),
    RECORD_STATUS_FAIL(2, "失败"),
    ;

    private Integer code;
    private String desc;

    RecordStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Optional<RecordStatus> getEnumByCode(Integer code) {
        return Arrays.stream(values())
                    .filter(e -> e.code.equals(code))
                    .findFirst();
    }

}
