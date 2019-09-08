package com.cqupt.imis.controller.api;

import com.cqupt.imis.service.ProjectService;
import com.cqupt.imis.service.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoujun
 */
@RestController
@RequestMapping("/api/imis")
public class ProjectApiController {
    @Resource
    private ProjectService projectService;

    @RequestMapping("/loadAllProjects")
    public ResponseEntity<?> loadAllProjects(){
        List<Project> projects=projectService.getAllProjects();
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }
}
