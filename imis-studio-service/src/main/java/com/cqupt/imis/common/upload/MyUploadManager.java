package com.cqupt.imis.common.upload;

import com.qiniu.storage.UploadManager;
import lombok.Data;

/**
 * Created by zhoujun on 2018/7/29.
 */
@Data
public class MyUploadManager {
    private UploadManager uploadManager;
    private String uploadToken;
}
