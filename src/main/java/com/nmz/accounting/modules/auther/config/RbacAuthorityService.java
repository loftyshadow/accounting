package com.nmz.accounting.auther.config;

import com.nmz.authserver.entity.QSysResourceEntity;
import com.nmz.authserver.entity.QSysRoleResourcesEntity;
import com.nmz.authserver.entity.QSysUserEntity;
import com.nmz.authserver.entity.QSysUserRoleEntity;
import com.nmz.authserver.utils.SecurityUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RbacAuthorityService {

    private static final Logger logger = LoggerFactory.getLogger(RbacAuthorityService.class);
    private final JPAQueryFactory jpaQueryFactory;
    // 所有权限标识
    private final String ALL_PERMISSION = "*:*:*";


    public boolean hasPermission(String permission) {
        logger.debug("进入RBAC动态鉴权判断");
        Long userId = SecurityUtil.getUserIdBySecurity();
        QSysUserEntity sysUserEntity = QSysUserEntity.sysUserEntity;
        QSysUserRoleEntity sysUserRoleEntity = QSysUserRoleEntity.sysUserRoleEntity;
        QSysRoleResourcesEntity sysRoleResourcesEntity = QSysRoleResourcesEntity.sysRoleResourcesEntity;
        QSysResourceEntity sysResourceEntity = QSysResourceEntity.sysResourceEntity;
        List<String> resources = jpaQueryFactory
                .select(sysResourceEntity.resourceName)
                .from(sysUserEntity)
                .leftJoin(sysUserRoleEntity)
                .on(sysUserEntity.userId.eq(sysUserRoleEntity.userId))
                .leftJoin(sysRoleResourcesEntity)
                .on(sysUserRoleEntity.roleId.eq(sysRoleResourcesEntity.roleId))
                .leftJoin(sysResourceEntity)
                .on(sysRoleResourcesEntity.resourceId.eq(sysResourceEntity.resourceId))
                .where(sysUserEntity.userId.eq(userId))
                .fetch();
        logger.debug("用户对应权限：{}", resources);
        return resources.contains(ALL_PERMISSION) || resources.contains(permission);
    }


}
