package main;

import dao.inter.CountryDaoInter;
import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;

public class Main {
    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        SkillDaoInter skillDao = Context.instanceSkillDao();
        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
        CountryDaoInter countryDao = Context.instanceCountryDao();
        System.out.println(countryDao.getAllCountries());
    }
}

