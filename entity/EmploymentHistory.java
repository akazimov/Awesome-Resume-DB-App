package database.entity;

import java.sql.Date;
import java.util.List;

public class EmploymentHistory {
    private int userId;
    private List<String> header;
    private List<Date> beginDate;
    private List<Date> endDate;
    private List<String> jobDescription;

    public EmploymentHistory() {
    }

    public EmploymentHistory(int userId, List<String> header, List<Date> beginDate, List<Date> endDate, List<String> jobDescription) {
        this.userId = userId;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<Date> getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(List<Date> beginDate) {
        this.beginDate = beginDate;
    }

    public List<Date> getEndDate() {
        return endDate;
    }

    public void setEndDate(List<Date> endDate) {
        this.endDate = endDate;
    }

    public List<String> getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(List<String> jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "userId=" + userId +
                ", header=" + header +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDescription=" + jobDescription +
                '}';
    }
}
