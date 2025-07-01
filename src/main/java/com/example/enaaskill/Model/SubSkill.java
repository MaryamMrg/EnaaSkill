package com.example.enaaskill.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SubSkillId;

    private String SubSkillName;
    private Status SubSkillStatus;

    public SubSkill(Long subSkillId, String subSkillName, Status subSkillStatus) {
        SubSkillId = subSkillId;
        SubSkillName = subSkillName;
        SubSkillStatus = subSkillStatus;
    }

    public SubSkill() {
    }

    public Long getSubSkillId() {
        return SubSkillId;
    }

    public void setSubSkillId(Long subSkillId) {
        SubSkillId = subSkillId;
    }

    public String getSubSkillName() {
        return SubSkillName;
    }

    public void setSubSkillName(String subSkillName) {
        SubSkillName = subSkillName;
    }

    public Status getSubSkillStatus() {
        return SubSkillStatus;
    }

    public void setSubSkillStatus(Status subSkillStatus) {
        SubSkillStatus = subSkillStatus;
    }
}
