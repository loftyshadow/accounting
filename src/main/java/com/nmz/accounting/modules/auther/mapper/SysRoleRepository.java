package com.nmz.accounting.modules.auther.mapper;

import com.nmz.accounting.modules.auther.entity.SysRoleMenuEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:23
 */
@Repository
public interface SysRoleRepository extends CrudRepository<SysRoleMenuEntity, Long>, QuerydslPredicateExecutor<SysRoleMenuEntity> {
}
