package com.iot.assetcreditinformationsystem.service;

import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


public interface FileService {

    List<Map<String,Object>> filesUpload(MultipartFile[] files,Integer userId, Integer preAssessmentReportId, String picClassify, boolean isOverride);

    void fileDownload(HttpServletResponse httpServletResponse,String fileName);

    ResponseModel fileDelete(String fileName);
}
