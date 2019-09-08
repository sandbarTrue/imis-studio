package com.cqupt.imis.service.impl;

import com.cqupt.imis.mapper.ProjectMapper;
import com.cqupt.imis.models.ProjectDao;
import com.cqupt.imis.service.ProjectService;
import com.cqupt.imis.service.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zhoujun
 * @date 2018/8/5
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getAllProjects() {
        return convertToProjects(projectMapper.selectAll());
    }
    private List<Project> convertToProjects(List<ProjectDao> projectDaos){
        if(CollectionUtils.isEmpty(projectDaos)){
            return new ArrayList<>();
        }
        return projectDaos.stream().map(this::convertBean).collect(Collectors.toList());
    }
    private Project convertBean(ProjectDao source){
        if(source==null){
            return null;
        }
        Project target=new Project();
        target.setContributor(source.getContributor());
        target.setImg(source.getImg());
        target.setInfo(source.getInfo());
        target.setLink(source.getLink());
        target.setName(source.getName());
        target.setId(source.getId());
        return target;
    }
}
