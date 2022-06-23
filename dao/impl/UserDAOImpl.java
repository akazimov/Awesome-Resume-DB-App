package dao.impl;

import entity.Country;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAOImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int coountryId = rs.getInt("nationality_id");
        String coountryStr = rs.getString("nationality");
        int birthplaceID = rs.getInt("birthplace_id");
        String birthPlaceStr = rs.getString("birthplace");
        Date birthDate = rs.getDate("birthdate");
        Country country = new Country(coountryId,null,coountryStr);
        Country birthPlace = new Country(birthplaceID,birthPlaceStr,null);
        return new User(id,name,surname,phone,email, country, birthPlace,birthDate);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select" +
                    "    u.*," +
                    "    n.nationality as nationality," +
                    "    c.name as birthplace" +
                    " from user u" +
                    " left join country n on u.nationality_id = n.id" +
                    " left join country c on u.birthplace_id = c.id");

            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,phone=?,email=? where id=?");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getPhone());
            stmt.setString(4,u.getEmail());
            stmt.setInt(5,u.getId());
            return stmt.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = "+id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select" +
                    "    u.*," +
                    "    n.nationality as nationality," +
                    "    c.name as birthplace" +
                    " from user u" +
                    " left join country n on u.nationality_id = n.id" +
                    " left join country c on u.birthplace_id = c.id where u.id = "+userId);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                result = getUser(rs);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,phone,email) values(?,?,?,?)");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getPhone());
            stmt.setString(4,u.getEmail());
            return stmt.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
