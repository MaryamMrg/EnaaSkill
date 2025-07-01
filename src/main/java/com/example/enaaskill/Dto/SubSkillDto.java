package com.example.enaaskill.Dto;

import com.example.enaaskill.Model.Status;

public class SubSkillDto {

    private Long subSkillId;
    private String subSkillName;
    private Status status;


    public SubSkillDto(Long subSkillId, String subSkillName, Status status) {
        this.subSkillId = subSkillId;
        this.subSkillName = subSkillName;
        this.status = status;
    }


    public SubSkillDto() {
    }

    public Long getSubSkillId() {
        return subSkillId;
    }

    public void setSubSkillId(Long subSkillId) {
        this.subSkillId = subSkillId;
    }

    public String getSubSkillName() {
        return subSkillName;
    }

    public void setSubSkillName(String subSkillName) {
        this.subSkillName = subSkillName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
