package com.nmz.accounting.modules.record.entity;

import com.nmz.accounting.modules.common.entity.BaseEntity;
import com.nmz.accounting.modules.common.enums.DeleteStatusEnum;
import com.nmz.accounting.modules.common.enums.YesNoEnum;
import com.nmz.accounting.modules.record.enums.BillTypeEnum;
import com.nmz.accounting.modules.record.enums.PayMethodenum;
import com.nmz.accounting.modules.record.enums.RecordStatus;
import com.nmz.accounting.modules.record.enums.ChangeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-14:35
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "accounting_record")
public class RecordEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id", nullable = false)
    private Long recordId;

    @Enumerated
    @Column(name = "pay_method")
    @Schema(description = "支付方式")
    private PayMethodenum payMethod;

    @Column(name = "record_desc")
    @Schema(description = "记录描述")
    private String recordDesc;

    @Enumerated
    @Column(name = "record_type")
    @Schema(description = "记录类型0-收入，1-支出", example = "0")
    private ChangeTypeEnum changeType;

    @Column(name = "after_change_money", precision = 19, scale = 2)
    @Schema(description = "变动后金额", example = "0.00")
    private BigDecimal afterChangeMoney;

    @Column(name = "change_money", precision = 19, scale = 2)
    private BigDecimal changeMoney;

    @Enumerated
    @Column(name = "include_in")
    @Schema(description = "是否包含在收支统计中", example = "0")
    private YesNoEnum includeIn;

    @Enumerated
    @Column(name = "bill_type")
    @Schema(description = "账单类型", example = "0")
    private BillTypeEnum billType;

    @Column(name = "payee_id")
    @Schema(description = "收款人id", example = "0")
    private Long payeeId;

    @Column(name = "payee_name")
    @Schema(description = "收款人名称", example = "0")
    private String payeeName;

    @Enumerated
    @Column(name = "record_status")
    @Schema(description = "记录状态", example = "0")
    private RecordStatus recordStatus;

    private RecordEntity(Builder builder) {
        setCreateUser(builder.createUser);
        setUpdateUser(builder.updateUser);
        setCreatTime(builder.creatTime);
        setUpdateTime(builder.updateTime);
        setDeleteStatus(builder.deleteStatus);
        setRemarks(builder.remarks);
        setRecordId(builder.recordId);
        setPayMethod(builder.payMethod);
        setRecordDesc(builder.recordDesc);
        setChangeType(builder.changeType);
        setAfterChangeMoney(builder.afterChangeMoney);
        setChangeMoney(builder.changeMoney);
        setIncludeIn(builder.includeIn);
        setBillType(builder.billType);
        setPayeeId(builder.payeeId);
        setPayeeName(builder.payeeName);
        setRecordStatus(builder.recordStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordEntity record = (RecordEntity) o;
        return Objects.equals(recordId, record.recordId) && payMethod == record.payMethod && Objects.equals(recordDesc, record.recordDesc) && changeType == record.changeType && Objects.equals(afterChangeMoney, record.afterChangeMoney) && Objects.equals(changeMoney, record.changeMoney) && includeIn == record.includeIn && billType == record.billType && recordStatus == record.recordStatus;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(recordId);
        result = 31 * result + Objects.hashCode(payMethod);
        result = 31 * result + Objects.hashCode(recordDesc);
        result = 31 * result + Objects.hashCode(changeType);
        result = 31 * result + Objects.hashCode(afterChangeMoney);
        result = 31 * result + Objects.hashCode(changeMoney);
        result = 31 * result + Objects.hashCode(includeIn);
        result = 31 * result + Objects.hashCode(billType);
        result = 31 * result + Objects.hashCode(recordStatus);
        return result;
    }

    public RecordEntity() {
    }


    public static final class Builder {
        private String createUser;
        private String updateUser;
        private Date creatTime;
        private Date updateTime;
        private DeleteStatusEnum deleteStatus;
        private String remarks;
        private Long recordId;
        private PayMethodenum payMethod;
        private String recordDesc;
        private ChangeTypeEnum changeType;
        private BigDecimal afterChangeMoney;
        private BigDecimal changeMoney;
        private YesNoEnum includeIn;
        private BillTypeEnum billType;
        private Long payeeId;
        private String payeeName;
        private RecordStatus recordStatus;

        public Builder() {
        }

        public Builder setCreateUser(String val) {
            createUser = val;
            return this;
        }

        public Builder setUpdateUser(String val) {
            updateUser = val;
            return this;
        }

        public Builder setCreatTime(Date val) {
            creatTime = val;
            return this;
        }

        public Builder setUpdateTime(Date val) {
            updateTime = val;
            return this;
        }

        public Builder setDeleteStatus(DeleteStatusEnum val) {
            deleteStatus = val;
            return this;
        }

        public Builder setRemarks(String val) {
            remarks = val;
            return this;
        }

        public Builder setRecordId(Long val) {
            recordId = val;
            return this;
        }

        public Builder setPayMethod(PayMethodenum val) {
            payMethod = val;
            return this;
        }

        public Builder setRecordDesc(String val) {
            recordDesc = val;
            return this;
        }

        public Builder setChangeType(ChangeTypeEnum val) {
            changeType = val;
            return this;
        }

        public Builder setAfterChangeMoney(BigDecimal val) {
            afterChangeMoney = val;
            return this;
        }

        public Builder setChangeMoney(BigDecimal val) {
            changeMoney = val;
            return this;
        }

        public Builder setIncludeIn(YesNoEnum val) {
            includeIn = val;
            return this;
        }

        public Builder setBillType(BillTypeEnum val) {
            billType = val;
            return this;
        }

        public Builder setPayeeId(Long val) {
            payeeId = val;
            return this;
        }

        public Builder setPayeeName(String val) {
            payeeName = val;
            return this;
        }

        public Builder setRecordStatus(RecordStatus val) {
            recordStatus = val;
            return this;
        }

        public RecordEntity build() {
            return new RecordEntity(this);
        }
    }
}
