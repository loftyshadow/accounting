package com.nmz.accounting.modules.record.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-15:41
 */
public enum PayMethodenum {
    PAY_METHOD_CASH(0, "现金"),
    PAY_METHOD_BANK_CARD(1, "银行卡"),
    PAY_METHOD_ALIPAY(2, "支付宝"),
    PAY_METHOD_WECHAT_PAY(3, "微信支付"),
    PAY_METHOD_OTHER(4, "其他"),
    ;

    private final Integer code;
    private final String desc;

    public static Optional<PayMethodenum> getPayMethodByCode(Integer code) {
        return Arrays.stream(values())
                .filter(payMethodenum -> payMethodenum.getCode().equals(code))
                .findFirst();
    }

    PayMethodenum(Integer code, String desc) {
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
