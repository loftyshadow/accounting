package com.nmz.accounting.auther.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:42
 */
@Data
public class SysUserRoleEntityPK implements Serializable {
    private long userId;
    private long roleId;
}
