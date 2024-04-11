package com.nmz.accounting.modules.auther.mapper;

import com.nmz.accounting.modules.auther.entity.SysUserEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:50
 */
@Repository
public interface SysUserRepository extends CrudRepository<SysUserEntity, Long>, QuerydslPredicateExecutor<SysUserEntity> {

    SysUserEntity findByUserName(String userName);

}
