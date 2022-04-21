package com.thylovezj.hospital.model.dao;

import com.thylovezj.hospital.model.pojo.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}