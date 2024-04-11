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
 * @Date: 2023/9/27-21:14
 */
@Getter
@Setter
@Entity
@Schema(title = "用户信息表")
@Table(name = "sys_user", catalog = "")
public class SysUserEntity {
    @Schema(name = "用户ID", description = "用户ID属性", format = "int64", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Schema(name = "用户名", description = "用户名属性", format = "string", example = "admin")
    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    private String userName;

    @Schema(name = "密码", description = "密码属性", format = "string", example = "admin")
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Schema(name = "删除标识", description = "删除标识属性", format = "int32", example = "0")
    @Basic
    @Column(name = "del_flag", nullable = true)
    private Boolean delFlag;

    @Schema(name = "邮箱", description = "邮箱属性", format = "string", example = "example@qq.com")
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Schema(name = "手机号", description = "手机号属性", format = "int32", example = "1234567890")
    @Basic
    @Column(name = "phone_number", nullable = true)
    private Integer phoneNumber;

    @Schema(name = "创建时间", description = "创建时间属性", format = "string", example = "2023-09-27 21:14:14")
    @Basic
    @Column(name = "creat_time", nullable = true)
    private Long creatTime;

    @Schema(name = "更新时间", description = "更新时间属性", format = "string", example = "2023-09-27")
    @Basic
    @Column(name = "update_time", nullable = true)
    private Long updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserEntity that = (SysUserEntity) o;

        if (!Objects.equals(userId, that.userId)) return false;
        if (!Objects.equals(userName, that.userName)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(delFlag, that.delFlag)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        if (!Objects.equals(creatTime, that.creatTime)) return false;
        return Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
