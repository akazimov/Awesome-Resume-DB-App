package database.dao.inter;

import database.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAllSkills();

    int getIdBySkillName(String name);
}
