package database.main;

import database.dao.impl.*;
import database.dao.inter.*;

public class Context {
    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }
    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }
    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkill() {
        return new UserSkillDaoImpl();
    }
}
