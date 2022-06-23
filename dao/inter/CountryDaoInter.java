package dao.inter;

import entity.Country;

import java.sql.ResultSet;
import java.util.List;

public interface CountryDaoInter {
    public List<Country> getAllCountries();

}
