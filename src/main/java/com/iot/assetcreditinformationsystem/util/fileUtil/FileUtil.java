package com.iot.assetcreditinformationsystem.util.fileUtil;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

public interface FileUtil {

    boolean filesUpload(MultipartFile[] files, String path);

    ResponseFileInfo fileUpload(MultipartFile file,String path);

    void fileDownload(HttpServletResponse httpServletResponse,File file);
}
