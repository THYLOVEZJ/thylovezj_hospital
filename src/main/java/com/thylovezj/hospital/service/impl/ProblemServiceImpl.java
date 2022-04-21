package com.thylovezj.hospital.service.impl;

import com.thylovezj.hospital.common.Constant;
import com.thylovezj.hospital.exception.ThylovezjHospitalException;
import com.thylovezj.hospital.exception.ThylovezjHospitalExceptionEnum;
import com.thylovezj.hospital.model.dao.ProblemMapper;
import com.thylovezj.hospital.model.pojo.Problem;
import com.thylovezj.hospital.model.request.AddProblemReq;
import com.thylovezj.hospital.model.vo.ProblemVo;
import com.thylovezj.hospital.service.ProblemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    ProblemMapper problemMapper;

    /**
     * @param subNum
     * @param objNum
     * @return
     */
    @Override
    public List<ProblemVo> getProblem(int subNum, int objNum) {
        List<ProblemVo> problems = new ArrayList<>();
        //查看数据库中问题个数，sNum是客观题问题数量,oNum是主观题问题数量
        int sNum = problemMapper.calculateNum(Constant.subType);
        int oNum = problemMapper.calculateNum(Constant.objType);
        if (subNum > sNum || objNum > oNum) {
            throw new ThylovezjHospitalException(ThylovezjHospitalExceptionEnum.PROBLEM_NOT_ENOUGH);
        }
        //获取数据库中相应的问题
        List<Problem> subProblemList = problemMapper.getProblem(Constant.subType, subNum);
        List<Problem> objProblemList = problemMapper.getProblem(Constant.objType, objNum);
        for (Problem subProblem : subProblemList) {
            ProblemVo problemVo = new ProblemVo();
            BeanUtils.copyProperties(subProblem, problemVo);
            problems.add(problemVo);
        }
        for (Problem objProblem : objProblemList) {
            ProblemVo problemVo = new ProblemVo();
            BeanUtils.copyProperties(objProblem, problemVo);
            problems.add(problemVo);
        }
        return problems;
    }

    @Override
    public void addProblem(AddProblemReq addProblemReq) {
        Problem problem = new Problem();
        BeanUtils.copyProperties(addProblemReq, problem);
        problem.setCreateTime(new Date());
        problem.setUpdateTime(new Date());
        int count = problemMapper.insertSelective(problem);
        if (count == 0) {
            throw new ThylovezjHospitalException(ThylovezjHospitalExceptionEnum.INSERT_FAILED);
        }
    }
}
