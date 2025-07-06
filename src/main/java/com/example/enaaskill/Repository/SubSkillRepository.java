package com.example.enaaskill.Repository;

import com.example.enaaskill.Model.Status;
import com.example.enaaskill.Model.SubSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubSkillRepository extends JpaRepository<SubSkill, Long> {

    List<SubSkill> findBySkill_SkillId(Long skillId);



    @Query("SELECT COUNT(s) FROM SubSkill s WHERE s.skill.skillId = :skillId AND s.SubSkillStatus = :status")
    long countBySkillIdAndStatus(@Param("skillId") Long skillId, @Param("status") Status status);

    @Query("SELECT COUNT(s) FROM SubSkill s WHERE s.skill.skillId = :skillId")
    long countBySkillId(@Param("skillId") Long skillId);

}
