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


import java.util.Arrays;
import java.util.List;

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
        inputDto.setSkillName("environment");
        System.out.println("input : "+inputDto.getSkillName());
        Skill skillEntity = new Skill();
        skillEntity.setSkillName("environment");

        Skill savedSkill = new Skill();
        savedSkill.setSkillId(1L);
        savedSkill.setSkillName("environment");

        SkillDto expectedDto = new SkillDto();
        expectedDto.setSkillId(1L);
        expectedDto.setSkillName("environment");
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
        assertEquals("environment", result.getSkillName());


        //verify
        verify(skillMapper).toEntity(inputDto);
        verify(skillRepository).save(skillEntity);
        verify(skillMapper).toDto(savedSkill);
    }




    @Test
    void getAllSkills_shouldReturnListOfSkillDtos() {
        // Arrange
        Skill skill1 = new Skill();
        skill1.setSkillId(1L);
        skill1.setSkillName("Java");

        Skill skill2 = new Skill();
        skill2.setSkillId(2L);
        skill2.setSkillName("Spring Boot");

        List<Skill> skillList = Arrays.asList(skill1, skill2);

        SkillDto dto1 = new SkillDto();
        dto1.setSkillId(1L);
        dto1.setSkillName("Java");
        System.out.println("dto1 : "+dto1.getSkillName());
        SkillDto dto2 = new SkillDto();
        dto2.setSkillId(2L);
        dto2.setSkillName("Spring Boot");
        System.out.println("dto2 : "+ dto2.getSkillName());
        List<SkillDto> expectedDtos = Arrays.asList(dto1, dto2);
        System.out.println("expected dtos : " +expectedDtos.toString());
        when(skillRepository.findAll()).thenReturn(skillList);
        when(skillMapper.toDtos(skillList)).thenReturn(expectedDtos);

        // Act
        List<SkillDto> result = skillService.getAllSkills();
        System.out.println("result : " +result.toString());
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Java", result.get(0).getSkillName());
        assertEquals("Spring Boot", result.get(1).getSkillName());

        verify(skillRepository, times(1)).findAll();
        verify(skillMapper, times(1)).toDtos(skillList);




    }
}
