package com.thylovezj.hospital.model.dao;

import com.thylovezj.hospital.model.pojo.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}