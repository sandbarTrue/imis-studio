package com.cqupt.imis.mapper;

import com.cqupt.imis.models.ProjectDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhoujun
 */
@Mapper
public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated
     */
    int insert(ProjectDao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated
     */
    ProjectDao selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated
     */
    List<ProjectDao> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProjectDao record);
}