package com.thylovezj.hospital.model.dao;

import com.thylovezj.hospital.model.pojo.Problem;
import com.thylovezj.hospital.model.vo.ProblemVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    int calculateNum(Integer type);

    List<Problem> getProblem(@Param("type") Integer type,@Param("num") Integer num);
}