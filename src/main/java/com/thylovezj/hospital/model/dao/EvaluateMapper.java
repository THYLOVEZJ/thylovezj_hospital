package com.thylovezj.hospital.model.dao;

import com.thylovezj.hospital.model.pojo.Evaluate;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}