package com.example.enaaskill.Dto;

public class SkillDto {

    private Long SkillId;
    private String skillName;
    private boolean isValidated;

    public SkillDto(Long skillId, String skillName, boolean isValidated) {
        SkillId = skillId;
        this.skillName = skillName;
        this.isValidated = isValidated;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillDto() {
    }

    public Long getSkillId() {
        return SkillId;
    }

    public void setSkillId(Long skillId) {
        SkillId = skillId;
    }



    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }


    @Override
    public String toString() {
        return "SkillDto{" +
                "SkillId=" + SkillId +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
