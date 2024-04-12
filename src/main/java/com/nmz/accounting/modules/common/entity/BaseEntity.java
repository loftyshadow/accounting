package com.nmz.accounting.modules.common.entity;

import com.nmz.accounting.modules.common.enums.DeleteStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-14:36
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "创建人")
    @Column(name = "create_user")
    @CreatedBy
    private String createUser;

    @Schema(description = "更新人")
    @Column(name = "update_user")
    @LastModifiedBy
    private String updateUser;

    @Schema(description = "创建时间")
    @Temporal(TemporalType.DATE)
    @Column(name = "creat_time")
    @CreatedDate
    private Date creatTime;

    @Schema(description = "更新时间")
    @Temporal(TemporalType.DATE)
    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;

    @Schema(description = "删除状态")
    @Enumerated
    @Column(name = "delete_status")
    private DeleteStatusEnum deleteStatus;

    @Column(name = "remarks")
    @Schema(description = "备注")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public DeleteStatusEnum getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(DeleteStatusEnum deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
