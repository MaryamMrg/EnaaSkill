package com.example.enaaskill;
import com.example.enaaskill.Dto.SubSkillDto;
import com.example.enaaskill.Mapper.SubSkillMapper;
import com.example.enaaskill.Model.SubSkill;
import com.example.enaaskill.Repository.SubSkillRepository;
import com.example.enaaskill.Service.SkillService;
import com.example.enaaskill.Service.SubSkillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class SubSkillServiceTest {



    @Mock
    private SubSkillRepository subSkillRepository;

    @Mock
    private SubSkillMapper subSkillMapper;

    @Mock
    private SkillService skillService; // Included only because it's in the constructor

    @InjectMocks
    private SubSkillService subSkillService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSubSkill_shouldReturnSavedSubSkillDto() {
        // Arrange
        SubSkillDto subSkillDto = new SubSkillDto();
        subSkillDto.setSubSkillId(1L);
        subSkillDto.setSubSkillName("Object-Oriented Programming");


        System.out.println("subskilldto : "+subSkillDto.getSubSkillName());

        SubSkill subSkillEntity = new SubSkill();
        subSkillEntity.setSubSkillId(1L);
        subSkillEntity.setSubSkillName("Object-Oriented Programming");

        System.out.println("subskillEntiy : " +subSkillEntity.getSubSkillName());


        SubSkill savedSubSkill = new SubSkill();
        savedSubSkill.setSubSkillId(1L);
        savedSubSkill.setSubSkillName("Object-Oriented Programming");


        System.out.println("saved subskill : "+savedSubSkill.getSubSkillName());


        when(subSkillMapper.toEntity(subSkillDto)).thenReturn(subSkillEntity);
        when(subSkillRepository.save(subSkillEntity)).thenReturn(savedSubSkill);
        when(subSkillMapper.toDto(savedSubSkill)).thenReturn(subSkillDto);

        // Act
        SubSkillDto result = subSkillService.createSubSkill(subSkillDto);

        System.out.println("result : " +result.getSubSkillName());
        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getSubSkillId());
        assertEquals("Object-Oriented Programming", result.getSubSkillName());

        verify(subSkillMapper).toEntity(subSkillDto);
        verify(subSkillRepository).save(subSkillEntity);
        verify(subSkillMapper).toDto(savedSubSkill);
    }
}
