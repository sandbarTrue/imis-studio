package com.cqupt.imis.config;

import com.cqupt.imis.common.upload.MyUploadManager;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhoujun on 2018/7/29.
 */
@org.springframework.context.annotation.Configuration
public class UploadManagerConfig {
    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String  secretKey;

    @Value("${bucketName}")
    private String bucketName;

    @Bean
    public MyUploadManager uploadManager(){
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucketName);
        MyUploadManager myUploadManager=new MyUploadManager();
        myUploadManager.setUploadManager(uploadManager);
        myUploadManager.setUploadToken(upToken);
        return myUploadManager;
    }
}
