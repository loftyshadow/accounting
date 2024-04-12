package com.nmz.accounting.modules.record.mapper;

import com.nmz.accounting.modules.record.entity.RecordEntity;
import com.nmz.accounting.modules.record.enums.BillTypeEnum;
import com.nmz.accounting.modules.record.enums.PayMethodenum;
import com.nmz.accounting.modules.record.enums.RecordStatus;
import com.nmz.accounting.modules.record.enums.ChangeTypeEnum;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/4/12-16:56
 */
@SpringBootTest
@Slf4j
class RecordRepositoryTest {

    @Autowired
    private RecordRepository underTest;

    @Test
    public void testInsert() {
        // given
        RecordEntity record = new RecordEntity.Builder()
                .setRecordDesc("test")
                .setRecordStatus(RecordStatus.RECORD_STATUS_PENDING)
                .setChangeType(ChangeTypeEnum.RECORD_TYPE_INCOME)
                .setBillType(BillTypeEnum.CATERING_DELICACIES)
                .setPayMethod(PayMethodenum.PAY_METHOD_CASH)
                .setCreateUser("test")
                .build();

        // when
        underTest.save(record);

        // then
        Assertions.assertEquals(record, underTest.findById(record.getRecordId()).get());

    }

}