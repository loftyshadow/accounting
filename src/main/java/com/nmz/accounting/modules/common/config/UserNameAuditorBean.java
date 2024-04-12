package com.nmz.accounting.modules.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

import static com.nmz.accounting.modules.auther.utils.SecurityUtil.getUserNameBySecurity;


/**
 * 在jpa.save方法被调用的时候，时间字段会自动设置并插入数据库，但是CreatedBy和LastModifiedBy并没有赋值，
 * 需要实现AuditorAware接口来返回你需要插入的值。
 */
@Configuration
public class UserNameAuditorBean implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(getUserNameBySecurity());
        // return Optional.ofNullable("userTest");
    }
}