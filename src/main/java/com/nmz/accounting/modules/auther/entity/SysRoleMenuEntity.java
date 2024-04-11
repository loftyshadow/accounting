package com.nmz.accounting.modules.auther.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:45
 */
@Getter
@Setter
@Entity
@Schema(title = "角色菜单关联表")
@Table(name = "sys_role_menu", catalog = "")
@IdClass(SysRoleMenuEntityPK.class)
public class SysRoleMenuEntity {

    @Schema(name = "菜单ID", description = "菜单ID属性", format = "int64", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "menu_id", nullable = false)
    private long menuId;

    @Schema(name = "角色ID", description = "角色ID属性", format = "int64", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleMenuEntity that = (SysRoleMenuEntity) o;

        if (menuId != that.menuId) return false;
        return roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        int result = (int) (menuId ^ (menuId >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }
}
