package com.nmz.accounting.modules.auther.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:45
 */
@Setter
@Getter
@Entity
@Schema(name = "用户角色表")
@Table(name = "sys_role", catalog = "")
public class SysRoleEntity {

    @Schema(name = "角色ID", description = "角色ID属性", format = "int64", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private long roleId;

    @Schema(name = "角色名称", description = "角色名称属性", format = "string", example = "管理员")
    @Basic
    @Column(name = "role_name", nullable = true, length = 255)
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleEntity that = (SysRoleEntity) o;

        if (roleId != that.roleId) return false;
        return Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        int result = (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
