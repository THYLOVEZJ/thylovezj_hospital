package com.thylovezj.hospital.model.dao;

import com.thylovezj.hospital.model.pojo.Problem;

public interface ProblemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);
}