package com.iot.assetcreditinformationsystem.util.fileUtil;

import java.io.File;

/**
 * 文件保存后返回的信息模版
 */
public class ResponseFileInfo {

    private boolean isSuccessful;

    private File file;

    public ResponseFileInfo() {
    }

    public ResponseFileInfo(boolean isSuccessful, File file) {
        this.isSuccessful = isSuccessful;
        this.file = file;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
