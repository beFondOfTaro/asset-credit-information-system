package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.ParkingCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingConditionRepository extends JpaRepository<ParkingCondition,Integer> {
}
