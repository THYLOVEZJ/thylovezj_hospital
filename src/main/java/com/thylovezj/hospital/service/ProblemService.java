package com.thylovezj.hospital.service;

import com.thylovezj.hospital.model.pojo.Problem;
import com.thylovezj.hospital.model.request.AddProblemReq;
import com.thylovezj.hospital.model.vo.ProblemVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemService {
    List<ProblemVo> getProblem(int subNum, int objNum);

    void addProblem(AddProblemReq addProblemReq);
}
