package com.example.enaaskill.Mapper;


import com.example.enaaskill.Dto.SubSkillDto;
import com.example.enaaskill.Model.SubSkill;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubSkillMapper {

    SubSkill toEntity (SubSkillDto dto);

    SubSkillDto toDto(SubSkill subSkill);

    List<SubSkillDto> toDtos(List<SubSkill> subSkills);
}
