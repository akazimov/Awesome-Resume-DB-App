package database.dao.impl;

import database.dao.inter.AbstractDao;
import database.dao.inter.SkillDaoInter;
import database.entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("skill_name");
        return new Skill(id,name);
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

    @Override
    public int getIdBySkillName(String name) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select id from skills where skill_name = ?");
            stmt.setString(1,name);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
