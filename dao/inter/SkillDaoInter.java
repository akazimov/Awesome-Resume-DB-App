package dao.inter;

import entity.Skill;
import entity.UserSkill;

import java.util.List;

public interface SkillDaoInter {
    public Skill getSkillById(int id);
    public List<Skill> getAllSkills();
    public List<UserSkill> getAllSkillsByUserId(int userId);

}
