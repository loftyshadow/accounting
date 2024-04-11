package com.nmz.accounting.auther.entity;

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
@Getter
@Setter
@Entity
@Schema(title = "权限")
@Table(name = "sys_resource", catalog = "")
public class SysResourceEntity {

    @Schema(name = "资源ID", description = "资源ID属性", format = "int64", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "resource_id", nullable = false)
    private long resourceId;

    @Schema(name = "资源名称", description = "资源名称属性", format = "string", example = "用户管理")
    @Basic
    @Column(name = "resource_name", nullable = true, length = 255)
    private String resourceName;

    @Schema(name = "资源URL", description = "资源URL属性", format = "string", example = "/user")
    @Basic
    @Column(name = "resource_url", nullable = true, length = 255)
    private String resourceUrl;

    @Schema(name = "资源方法", description = "资源方法属性", format = "string", example = "GET")
    @Basic
    @Column(name = "resource_method", nullable = true, length = 255)
    private String resourceMethod;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysResourceEntity that = (SysResourceEntity) o;

        if (resourceId != that.resourceId) return false;
        if (!Objects.equals(resourceName, that.resourceName)) return false;
        if (!Objects.equals(resourceUrl, that.resourceUrl)) return false;
        return Objects.equals(resourceMethod, that.resourceMethod);
    }

    @Override
    public int hashCode() {
        int result = (int) (resourceId ^ (resourceId >>> 32));
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourceUrl != null ? resourceUrl.hashCode() : 0);
        result = 31 * result + (resourceMethod != null ? resourceMethod.hashCode() : 0);
        return result;
    }
}
