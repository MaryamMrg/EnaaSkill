package com.example.enaaskill.Dto;

public class SkillDto {

    private Long SkillId;
    private String SkillName;
    private boolean isValidated;

    public SkillDto(Long skillId, String skillName, boolean isValidated) {
        SkillId = skillId;
        SkillName = skillName;
        this.isValidated = isValidated;
    }

    public SkillDto() {
    }

    public Long getSkillId() {
        return SkillId;
    }

    public void setSkillId(Long skillId) {
        SkillId = skillId;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }
}
