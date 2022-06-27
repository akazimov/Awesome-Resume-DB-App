package database.dao.impl;

import database.dao.inter.AbstractDao;
import database.dao.inter.EmploymentHistoryDaoInter;
import database.entity.EmploymentHistory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {
    @Override
    public void addEmploymentHistory(EmploymentHistory employmentHistory) {
        try(Connection c = connect()) {
            int userId = employmentHistory.getUserId();
            List<String> header = employmentHistory.getHeader();
            List<Date> beginDate = employmentHistory.getBeginDate();
            List<Date> endDate = employmentHistory.getEndDate();
            List<String> jobDescription = employmentHistory.getJobDescription();
            for(int i=0;i<header.size();i++) {
                PreparedStatement stmt = c.prepareStatement("insert into employment_history(user_id,header,begin_date,end_date,job_description) values(?,?,?,?,?)");
                stmt.setInt(1,userId);
                stmt.setString(2, header.get(i));
                stmt.setDate(3,beginDate.get(i));
                stmt.setDate(4,endDate.get(i));
                stmt.setString(5, jobDescription.get(i));
                stmt.execute();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
