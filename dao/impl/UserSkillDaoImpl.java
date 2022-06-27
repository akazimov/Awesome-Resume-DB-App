package database.dao.impl;

import database.dao.inter.AbstractDao;
import database.dao.inter.UserSkillDaoInter;
import database.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {
    @Override
    public void addUserSkills(List<UserSkill> userSkills) {
        try(Connection c = connect()) {
            for(UserSkill u : userSkills) {
                PreparedStatement stmt = c.prepareStatement("insert into user_skill(user_id,skill_id,power) values(?,?,?)");
                stmt.setInt(1,u.getUserId());
                stmt.setInt(2,u.getSkillId());
                stmt.setInt(3,u.getPower());
                stmt.execute();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
