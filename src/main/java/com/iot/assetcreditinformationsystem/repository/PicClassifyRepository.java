package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.PicClassify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicClassifyRepository extends JpaRepository<PicClassify,Integer> {

    PicClassify findByClassify(String classify);
}
