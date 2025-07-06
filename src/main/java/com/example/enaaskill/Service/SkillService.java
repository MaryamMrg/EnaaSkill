package com.example.enaaskill.Service;


import com.example.enaaskill.Dto.SkillDto;
import com.example.enaaskill.Mapper.SkillMapper;
import com.example.enaaskill.Model.Skill;
import com.example.enaaskill.Model.Status;
import com.example.enaaskill.Repository.SkillRepository;
import com.example.enaaskill.Repository.SubSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {


   private final SkillRepository skillRepository;
   private final SkillMapper skillMapper;
   private final SubSkillRepository subSkillRepository;

    public SkillService(SkillRepository skillRepository, SkillMapper skillMapper, SubSkillRepository subSkillRepository) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
        this.subSkillRepository = subSkillRepository;
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


    public void checkAndUpdateSkillValidation(Long skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + skillId));

        long totalSubSkills = subSkillRepository.countBySkillId(skillId);
        long passedSubSkills = subSkillRepository.countBySkillIdAndStatus(skillId, Status.Passed);
//if all subskills are passed validate the skill
        if (totalSubSkills > 0 && passedSubSkills == totalSubSkills) {
            if (!skill.isValidated()) {
                skill.setValidated(true);
                skillRepository.save(skill);
                System.out.println("Skill " + skillId + " has been automatically validated!");
            }
        } else {
            // If not all subskills are passed, unvalidate the skill
            if (skill.isValidated()) {
                skill.setValidated(false);
                skillRepository.save(skill);
                System.out.println("Skill " + skillId + " validation has been revoked!");
            }
        }
    }
}
