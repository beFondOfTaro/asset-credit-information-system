package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.OutsidePicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutsidePictureRepository extends JpaRepository<OutsidePicture,Integer> {

    List<OutsidePicture> findByPicClassifyId(Integer picClassifyId);

    List<OutsidePicture> findByPreAssessmentReportId(Integer preAssessmentReportId);

    OutsidePicture findByPic(String pic);
}
