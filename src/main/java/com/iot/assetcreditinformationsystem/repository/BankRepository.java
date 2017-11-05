package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {
}
