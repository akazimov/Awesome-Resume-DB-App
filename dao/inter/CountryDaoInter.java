package database.dao.inter;

import database.entity.Country;

import java.util.List;

public interface CountryDaoInter {
    List<Country> getAllCountries();
    int getIdByCountryName(String name);
    int getIdByNationality(String name);
}
