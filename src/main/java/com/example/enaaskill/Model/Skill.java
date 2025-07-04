package com.example.enaaskill.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;


    private String skillName;

   private boolean isValidated;

    public Skill(Long skillId, String skillName, boolean isValidated) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.isValidated = isValidated;
    }

    public Skill() {
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }


    @OneToMany
    private List<SubSkill> subSkills = new ArrayList<SubSkill>();
}
