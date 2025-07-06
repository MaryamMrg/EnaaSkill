package com.example.enaaskill;

import com.example.enaaskill.Dto.SkillDto;
import com.example.enaaskill.Mapper.SkillMapper;
import com.example.enaaskill.Model.Skill;
import com.example.enaaskill.Repository.SkillRepository;
import com.example.enaaskill.Repository.SubSkillRepository;
import com.example.enaaskill.Service.SkillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class SkillServiceTest {


    @Mock
    private SkillRepository skillRepository;

    @Mock
    private SubSkillRepository subSkillRepository;

    @Mock
    private SkillMapper skillMapper;

    @InjectMocks
    private SkillService skillService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSkill_shouldReturnSkillDto() {
        // Arrange
        SkillDto inputDto = new SkillDto();
        inputDto.setSkillName("Docker");
        System.out.println("input : "+inputDto.getSkillName());
        Skill skillEntity = new Skill();
        skillEntity.setSkillName("Docker");

        Skill savedSkill = new Skill();
        savedSkill.setSkillId(1L);
        savedSkill.setSkillName("Docker");

        SkillDto expectedDto = new SkillDto();
        expectedDto.setSkillId(1L);
        expectedDto.setSkillName("Docker");
        System.out.println("expected skill :"+expectedDto.getSkillName());

        when(skillMapper.toEntity(inputDto)).thenReturn(skillEntity);
        when(skillRepository.save(skillEntity)).thenReturn(savedSkill);
        when(skillMapper.toDto(savedSkill)).thenReturn(expectedDto);

        // Act
        SkillDto result = skillService.createSkill(inputDto);

        System.out.println("result:" +result.getSkillName());
        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getSkillId());
        assertEquals("Docker", result.getSkillName());


        //verify
        verify(skillMapper).toEntity(inputDto);
        verify(skillRepository).save(skillEntity);
        verify(skillMapper).toDto(savedSkill);
    }
}
