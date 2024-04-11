package com.nmz.accounting.modules.auther.mapper;


import com.nmz.accounting.modules.auther.entity.SysUserRoleEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:25
 */
public interface SysUserRoleRepository extends CrudRepository<SysUserRoleEntity, Long>, QuerydslPredicateExecutor<SysUserRoleEntity> {
    SysUserRoleEntity findByUserId(long userId);
}
