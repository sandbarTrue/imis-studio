package com.cqupt.imis.service;

import com.cqupt.imis.service.model.Project;

import java.util.List;

/**
 * Created by zhoujun on 2018/8/5.
 */
public interface ProjectService {
    /**
     *获取所有的项目信息
     * @return
     */
    public List<Project> getAllProjects();

}
