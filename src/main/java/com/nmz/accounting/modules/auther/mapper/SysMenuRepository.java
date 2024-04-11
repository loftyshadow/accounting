package com.nmz.accounting.modules.auther.mapper;


import com.nmz.accounting.modules.auther.entity.SysMenuEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:22
 */
@Repository
public interface SysMenuRepository extends CrudRepository<SysMenuEntity, Long>, QuerydslPredicateExecutor<SysMenuEntity> {


    List<SysMenuEntity> findByParentId(Long parentId);

}
