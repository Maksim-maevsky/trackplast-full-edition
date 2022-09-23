package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.MailInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MailInfoRepository extends JpaRepository<MailInfo, UUID> {


}
