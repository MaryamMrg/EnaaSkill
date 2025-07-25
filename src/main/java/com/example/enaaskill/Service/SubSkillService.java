package com.example.enaaskill.Service;

import com.example.enaaskill.Dto.SubSkillDto;
import com.example.enaaskill.Mapper.SubSkillMapper;
import com.example.enaaskill.Model.SubSkill;
import com.example.enaaskill.Repository.SubSkillRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSkillService {

    private final SubSkillRepository subSkillRepository;
    private final SubSkillMapper subSkillMapper;
    private final SkillService skillService;

    public SubSkillService(SubSkillRepository subSkillRepository, SubSkillMapper subSkillMapper, SkillService skillService) {
        this.subSkillRepository = subSkillRepository;
        this.subSkillMapper = subSkillMapper;
        this.skillService = skillService;
    }


    public SubSkillDto createSubSkill(SubSkillDto subSkillDto) {

        SubSkill subSkill = subSkillMapper.toEntity(subSkillDto);
        SubSkill saved = subSkillRepository.save(subSkill);

        return subSkillMapper.toDto(saved);
    }


    public List<SubSkillDto> getAllSubSkills() {
        List<SubSkill> subSkills = subSkillRepository.findAll();
        return subSkillMapper.toDtos(subSkills);

    }

    public SubSkillDto getSubSkillById(Long subSkillId) {

        SubSkill subSkill = subSkillRepository.findById(subSkillId).orElseThrow(()->new RuntimeException("no matches skill id=" + subSkillId));
        return subSkillMapper.toDto(subSkill);
    }

    public void deleteSubSkill(Long subSkillId) {
        subSkillRepository.deleteById(subSkillId);
    }

    public SubSkillDto updateSubSkill(SubSkillDto subSkillDto,Long subSkillId) {
        SubSkill subSkill=subSkillRepository.findById(subSkillId).orElseThrow(()->new RuntimeException("not found"));
        subSkill.setSubSkillName(subSkillDto.getSubSkillName());
        subSkill.setSubSkillStatus(subSkillDto.getSubSkillStatus());
        SubSkill saved = subSkillRepository.save(subSkill);
        skillService.checkAndUpdateSkillValidation(saved.getSkill().getSkillId());

        return subSkillMapper.toDto(saved);
    }
}
