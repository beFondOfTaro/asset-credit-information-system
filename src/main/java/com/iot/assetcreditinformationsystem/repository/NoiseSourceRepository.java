package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.NoiseSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoiseSourceRepository extends JpaRepository<NoiseSource,Integer> {
}
