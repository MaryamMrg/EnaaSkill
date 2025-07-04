package com.example.enaaskill.Dto;

import com.example.enaaskill.Model.Status;

public class SubSkillDto {

    private Long subSkillId;
    private String subSkillName;
    private Status SubSkillStatus;

    private Long skillId;

    public SubSkillDto(Long subSkillId, String subSkillName, Status subSkillStatus, Long skillId) {
        this.subSkillId = subSkillId;
        this.subSkillName = subSkillName;
        SubSkillStatus = subSkillStatus;
        this.skillId = skillId;
    }

    public SubSkillDto() {
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
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


    public Status getSubSkillStatus() {
        return SubSkillStatus;
    }

    public void setSubSkillStatus(Status subSkillStatus) {
        SubSkillStatus = subSkillStatus;
    }
}
