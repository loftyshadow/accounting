package com.nmz.accounting.modules.record.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-16:19
 */
public enum BillTypeEnum {

    CATERING_DELICACIES(0, "餐饮"),
    CLOTHING_AND_DRESSING_UP(1, "服饰装扮"),
    DAILY_NECESSITIES(2, "日用百货"),
    HOME_DECORATION(3, "家居家装"),
    DIGITAL_APPLIANCES(4, "数码电器"),
    SPORTS_OUTDOOR(5, "运动户外"),
    BEAUTY_AND_HAIRDRESSING(6, "美容美发"),
    MATERNAL_INFANT_PARENT_CHILD_RELATIONSHIP(7, "母婴亲子"),
    PETS(8, "宠物"),
    TRANSPORTATION_AND_TRAVEL(9, "交通出行"),
    LOVE_CAR_MAINTENANCE(10, "爱车养车"),
    HOUSING_PROPERTY_MANAGEMENT(11, "住房物业"),
    HOTEL_TOURISM(12, "酒店旅游"),
    CULTURAL_LEISURE(13, "文化休闲"),
    EDUCATION_AND_TRAINING(14, "教育培训"),
    MEDICAL_HEALTH(15, "医疗健康"),
    LIFE_SERVICES(16, "生活服务"),
    PUBLIC_SERVICE(17, "公共服务"),
    BUSINESS_SERVICES(18, "商业服务"),
    PUBLIC_WELFARE_DONATIONS(19, "公益捐赠"),
    MUTUAL_ASSISTANCE_AND_PROTECTION(20, "互助保障"),
    INVESTMENT_AND_WEALTH_MANAGEMENT(21, "投资理财"),
    INSURANCE(22, "保险"),
    CREDIT_BORROWING_AND_REPAYMENT(23, "信用借还"),
    RECHARGE_PAYMENT(24, "充值缴费"),
    INCOME(25, "收入"),
    TRANSFER_RED_ENVELOPE(26, "转账红包"),
    PAYMENT_BY_RELATIVES_AND_FRIENDS(27, "亲友代付"),
    ACCOUNT(28, "账户存取"),
    REFUND(29, "退款"),
    OTHER(30, "其他"),
    ;

    public static Optional<BillTypeEnum> getEnumByCode(Integer code) {
        return Arrays.stream(values())
                    .filter(e -> e.code.equals(code))
                    .findFirst();
    }

    private final Integer code;
    private final String desc;

    BillTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
