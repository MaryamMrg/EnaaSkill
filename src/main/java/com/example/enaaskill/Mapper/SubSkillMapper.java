package com.example.enaaskill.Mapper;

import com.example.enaaskill.Dto.SubSkillDto;
import com.example.enaaskill.Model.SubSkill;
import com.example.enaaskill.Model.Skill;
import com.example.enaaskill.Repository.SkillRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SubSkillMapper {

    @Autowired
    protected SkillRepository skillRepository;

    @Mapping(target = "skill", source = "skillId", qualifiedByName = "skillIdToSkill")
    public abstract SubSkill toEntity(SubSkillDto dto);

    @Mapping(target = "skillId", source = "skill.skillId")
    public abstract SubSkillDto toDto(SubSkill subSkill);

    public abstract List<SubSkillDto> toDtos(List<SubSkill> subSkills);

    @Named("skillIdToSkill")
    protected Skill skillIdToSkill(Long skillId) {
        if (skillId == null) {
            return null;
        }
        return skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + skillId));
    }
}