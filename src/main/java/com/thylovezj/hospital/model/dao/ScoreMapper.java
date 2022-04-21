package com.thylovezj.hospital.model.dao;

import com.thylovezj.hospital.model.pojo.Score;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}