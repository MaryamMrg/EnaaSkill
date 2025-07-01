package com.example.enaaskill.Repository;

import com.example.enaaskill.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Long> {
}
