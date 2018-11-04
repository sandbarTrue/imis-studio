package com.cqupt.imis.service;

import com.qiniu.common.QiniuException;

import java.io.File;
import java.io.InputStream;

/**
 * Created by zhoujun on 2018/7/29.
 */
public interface UploadFileService {
    public String uploadFile(File file) throws QiniuException;

    public String uploadBytes(byte[] bytes,String name) throws QiniuException;

    public String uploadStream(InputStream inputStream,String name) throws QiniuException;
}
