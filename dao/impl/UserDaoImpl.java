package database.dao.impl;

import database.dao.inter.AbstractDao;
import database.dao.inter.CountryDaoInter;
import database.dao.inter.UserDaoInter;
import database.entity.User;
import database.main.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    private CountryDaoInter countryDao = Context.instanceCountryDao();
    @Override
    public boolean addUser(User u) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,profile_description,address,email,birthdate,birthplace_id,nationality_id,phone) values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getProfile());
            stmt.setString(4,u.getAddress());
            stmt.setString(5,u.getEmail());
            stmt.setDate(6,u.getBirthDate());
            stmt.setInt(7,countryDao.getIdByCountryName(u.getBirthPlace().getName()));
            stmt.setInt(8,countryDao.getIdByNationality(u.getNationality().getNationality()));
            stmt.setString(9,u.getPhone());
            return stmt.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getIdByUser(User u) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select id from user where name=? and surname=?" +
                    " and profile_description=? and email=? and phone=? and birthdate=? and" +
                    " nationality_id = ? and birthplace_id = ? and address=?");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getProfile());
            stmt.setString(4,u.getEmail());
            stmt.setString(5,u.getPhone());
            stmt.setDate(6,u.getBirthDate());
            stmt.setInt(7,countryDao.getIdByNationality(u.getNationality().getNationality()));
            stmt.setInt(8,countryDao.getIdByCountryName(u.getBirthPlace().getName()));
            stmt.setString(9,u.getAddress());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                return rs.getInt("id");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
