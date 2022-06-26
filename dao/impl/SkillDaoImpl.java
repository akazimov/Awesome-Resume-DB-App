package dao.impl;

import dao.inter.AbstractDAO;
import dao.inter.SkillDaoInter;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public Skill getSkillById(int id) {
        Skill result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skills where id = "+id);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                result = getSkill(rs);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> result = new ArrayList<>();
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skills");

            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                Skill u = getSkill(rs);
                result.add(u);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("skill_name");
        return new Skill(id,name);
    }

    @Override
    public List<UserSkill> getAllSkillsByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select" +
                    " u.*," +
                    " us.skill_id," +
                    " s.skill_name as skill_name," +
                    " us.power" +
                    " from" +
                    " user_skill us" +
                    " left join user u on us.user_id = u.id" +
                    " left join skills s on us.skill_id = s.id" +
                    " where" +
                    " us.user_id = "+userId);

            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillStr = rs.getString("skill_name");
        int power = rs.getInt("power");
        return new UserSkill(null,new User(userId),new Skill(skillId,skillStr),power);
    }
}
