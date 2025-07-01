package com.example.enaaskill.Service;


import com.example.enaaskill.Dto.SkillDto;
import com.example.enaaskill.Mapper.SkillMapper;
import com.example.enaaskill.Model.Skill;
import com.example.enaaskill.Repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {


   private final SkillRepository skillRepository;
   private final SkillMapper skillMapper;

    public SkillService(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }


    public SkillDto createSkill(SkillDto skillDto) {
        Skill skill = skillMapper.toEntity(skillDto);
        Skill savedSkill = skillRepository.save(skill);
        return skillMapper.toDto(savedSkill);
    }

    public SkillDto updateSkill(SkillDto skillDto,Long skillId) {
        Skill skill = skillRepository.findById(skillId).orElseThrow(()->new RuntimeException("not found"));
        skill.setSkillName(skillDto.getSkillName());
        skill.setValidated(skillDto.isValidated());
        Skill savedSkill = skillRepository.save(skill);
        return skillMapper.toDto(savedSkill);
    }
    public List<SkillDto> getAllSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skillMapper.toDtos(skills);
    }


    public SkillDto getSkillById(Long skillId) {
        Skill skill = skillRepository.findById(skillId).orElseThrow(()->new RuntimeException("not found"));
        return skillMapper.toDto(skill);
    }
    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }
}
