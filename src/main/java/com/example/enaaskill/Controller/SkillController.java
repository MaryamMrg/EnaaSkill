package com.example.enaaskill.Controller;

import com.example.enaaskill.Dto.SkillDto;
import com.example.enaaskill.Service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }


    @PostMapping
    public SkillDto createSkill(@RequestBody SkillDto skillDto) {
        return  skillService.createSkill(skillDto);
    }


    @GetMapping("/all")
    public List<SkillDto> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/skillId/{skillId}")
    public SkillDto getSkillById(@PathVariable("skillId") Long skillId) {
        return skillService.getSkillById(skillId);
    }
    

    @PutMapping("/update/{skillId}")
    public SkillDto updateSkill(@PathVariable Long skillId, @RequestBody SkillDto skillDto) {
        return skillService.updateSkill(skillDto, skillId);
    }

    @DeleteMapping("/{skillId}")

    public void deleteSkill(@PathVariable Long skillId) {
        skillService.deleteSkill(skillId);
    }
}
