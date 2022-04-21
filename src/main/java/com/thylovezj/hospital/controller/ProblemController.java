package com.thylovezj.hospital.controller;

import com.thylovezj.hospital.common.ApiRestResponse;
import com.thylovezj.hospital.model.pojo.Problem;
import com.thylovezj.hospital.model.request.AddProblemReq;
import com.thylovezj.hospital.model.vo.ProblemVo;
import com.thylovezj.hospital.service.ProblemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/evaluate/problem")
public class ProblemController {
    @Autowired
    ProblemService problemService;

    /**
     *返回问题接口
     * @param subNum 客观题个数
     * @param objNum 主观题个数
     * @return
     */
    @GetMapping("/get")
    public ApiRestResponse getQuestion(@RequestParam("sub_number") int subNum, @RequestParam("obj_number") int objNum) {
        List<ProblemVo> problem = problemService.getProblem(subNum,objNum);
        return ApiRestResponse.success(problem);
    }

    @PostMapping("/add")
    public ApiRestResponse addQuestion(@RequestBody AddProblemReq addProblemReq){
        problemService.addProblem(addProblemReq);
        return ApiRestResponse.success();
    }
}
