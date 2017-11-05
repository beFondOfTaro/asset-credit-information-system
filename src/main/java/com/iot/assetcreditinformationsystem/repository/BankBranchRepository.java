package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBranchRepository extends JpaRepository<BankBranch,Integer> {
}
