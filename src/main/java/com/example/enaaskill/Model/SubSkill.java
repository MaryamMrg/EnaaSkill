package com.example.enaaskill.Model;

import jakarta.persistence.*;

@Entity
public class SubSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SubSkillId;

    private String SubSkillName;
    private Status SubSkillStatus;

    public SubSkill() {
    }

    public SubSkill(Long subSkillId, String subSkillName, Status subSkillStatus, Skill skill) {
        SubSkillId = subSkillId;
        SubSkillName = subSkillName;
        SubSkillStatus = subSkillStatus;
        this.skill = skill;
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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @ManyToOne
    @JoinColumn(name = "skillId")
    private Skill skill;
}
