package com.example.enaaskill.Mapper;


import com.example.enaaskill.Dto.SkillDto;
import com.example.enaaskill.Model.Skill;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    Skill toEntity(SkillDto dto);

    SkillDto toDto(Skill skill);

    List<SkillDto> toDtos(List<Skill> skills);
}
