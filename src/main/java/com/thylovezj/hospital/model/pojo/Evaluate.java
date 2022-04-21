package com.thylovezj.hospital.model.pojo;

import java.util.Date;

public class Evaluate {
    private Integer id;

    private Integer evaluateId;

    private Integer beEvaluatedId;

    private Integer score;

    private String comment;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getBeEvaluatedId() {
        return beEvaluatedId;
    }

    public void setBeEvaluatedId(Integer beEvaluatedId) {
        this.beEvaluatedId = beEvaluatedId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}