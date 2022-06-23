package main;

import dao.impl.CountryDaoImpl;
import dao.impl.EmploymentHistoryDaoImpl;
import dao.impl.SkillDaoImpl;
import dao.impl.UserDAOImpl;
import dao.inter.CountryDaoInter;
import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao() {
        return new UserDAOImpl();
    }
    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() { return new CountryDaoImpl(); }

    public static SkillDaoInter instanceSkillDao() { return new SkillDaoImpl(); }
}
