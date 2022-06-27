package database.dao.impl;

import database.dao.inter.AbstractDao;
import database.dao.inter.CountryDaoInter;
import database.entity.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {
    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        return new Country(id,name,nationality);
    }
    @Override
    public List<Country> getAllCountries() {
        List<Country> result = new ArrayList<>();
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");

            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                Country u = getCountry(rs);
                result.add(u);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getIdByCountryName(String name) {
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select id from country where name='"+name+"'");
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                return rs.getInt("id");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getIdByNationality(String name) {
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select id from country where nationality='"+name+"'");
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
