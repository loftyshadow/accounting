package com.nmz.accounting.modules.record.mapper;

import com.nmz.accounting.modules.record.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
}