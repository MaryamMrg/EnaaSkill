package com.example.enaaskill.Controller;

import com.example.enaaskill.Dto.SubSkillDto;
import com.example.enaaskill.Model.Skill;
import com.example.enaaskill.Service.SkillService;
import com.example.enaaskill.Service.SubSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subskill")
public class SubSkillController {
    public final SubSkillService subSkillService;
    public final SkillService skillService;

    public SubSkillController(SubSkillService subSkillService, SkillService skillService) {
        this.subSkillService = subSkillService;
        this.skillService = skillService;
    }


    @PostMapping
    public SubSkillDto createSubSkill(@RequestBody SubSkillDto dto) {
        System.out.println("skill id received: " + dto.getSkillId());

        return subSkillService.createSubSkill(dto);
    }

    @GetMapping("/all")
    public List<SubSkillDto> getSubSkills() {
        return subSkillService.getAllSubSkills();
    }


    @DeleteMapping("/{subSkillId}")
    public void deleteSubSkill(@PathVariable Long subSkillId) {
        subSkillService.deleteSubSkill(subSkillId);

    }

    @PutMapping("/update/{subSkillId}")
    public SubSkillDto updateSubSkill(@PathVariable Long subSkillId, @RequestBody SubSkillDto dto) {
        return subSkillService.updateSubSkill(dto,subSkillId);
    }

    @GetMapping("/{subSkillId}")
    public SubSkillDto getSubSkill(@PathVariable Long subSkillId) {
        return subSkillService.getSubSkillById(subSkillId);
    }
}
