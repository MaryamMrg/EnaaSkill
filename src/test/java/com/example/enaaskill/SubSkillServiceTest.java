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

import java.util.Arrays;
import java.util.List;

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
    void createSubSkill() {
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


    @Test
    void getAllSubSkills() {
        // Arrange
        SubSkill sub1 = new SubSkill();
        sub1.setSubSkillId(1L);
        sub1.setSubSkillName("Encapsulation");

        System.out.println("subskill 1 :"+sub1.getSubSkillName());

        SubSkill sub2 = new SubSkill();
        sub2.setSubSkillId(2L);
        sub2.setSubSkillName("Polymorphism");

        System.out.println("subskill 2 :"+sub2.getSubSkillName());

        List<SubSkill> subSkills = Arrays.asList(sub1, sub2);


        System.out.println("subskills :"+subSkills.toString());


        SubSkillDto dto1 = new SubSkillDto();
        dto1.setSubSkillId(1L);
        dto1.setSubSkillName("Encapsulation");


        System.out.println("dto 1 : "+dto1.getSubSkillName());

        SubSkillDto dto2 = new SubSkillDto();
        dto2.setSubSkillId(2L);
        dto2.setSubSkillName("Polymorphism");
        System.out.println("dto 2 : "+dto2.getSubSkillName());

        List<SubSkillDto> expectedDtos = Arrays.asList(dto1, dto2);


        when(subSkillRepository.findAll()).thenReturn(subSkills);
        when(subSkillMapper.toDtos(subSkills)).thenReturn(expectedDtos);

        // Act
        List<SubSkillDto> result = subSkillService.getAllSubSkills();

        System.out.println("Expected: " + expectedDtos);
        System.out.println("Result: " + result);

        // Assert
        assertEquals(expectedDtos.size(), result.size());
        assertEquals(expectedDtos.get(0).getSubSkillName(), result.get(0).getSubSkillName());
        assertEquals(expectedDtos.get(1).getSubSkillName(), result.get(1).getSubSkillName());

        verify(subSkillRepository).findAll();
        verify(subSkillMapper).toDtos(subSkills);
    }
}
