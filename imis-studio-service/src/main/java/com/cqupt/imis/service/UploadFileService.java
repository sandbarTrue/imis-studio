package com.cqupt.imis.service;

import com.qiniu.common.QiniuException;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author zhoujun
 * @date 2018/7/29
 */
public interface UploadFileService {
    /**
     * 上传文件
     * @param file
     * @return
     * @throws QiniuException
     */
    public String uploadFile(File file) throws QiniuException;

    /**
     * 上传文件
     * @param bytes
     * @param name
     * @return
     * @throws QiniuException
     */
    public String uploadBytes(byte[] bytes,String name) throws QiniuException;

    /**
     * 上传文件
     * @param inputStream
     * @param name
     * @return
     * @throws QiniuException
     */
    public String uploadStream(InputStream inputStream,String name) throws QiniuException;
}
