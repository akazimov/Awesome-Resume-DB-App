package database.entity;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String profile;
    private String email;
    private String address;
    private String phone;
    private Date birthDate;
    private Country birthPlace;
    private Country nationality;
    private List<UserSkill> skills;
    private EmploymentHistory employmentHistory;

    public User() {
    }

    public User(int id, String name, String surname, String profile, String email, String address, String phone, Date birthDate, Country birthPlace, Country nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profile = profile;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.nationality = nationality;
    }

    public User(int id, String name, String surname, String profile, String email, String address, String phone, Date birthDate, Country birthPlace, Country nationality, List<UserSkill> skills, EmploymentHistory employmentHistory) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profile = profile;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.nationality = nationality;
        this.skills = skills;
        this.employmentHistory = employmentHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public EmploymentHistory getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(EmploymentHistory employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace=" + birthPlace +
                ", nationality=" + nationality +
                ", skills=" + skills +
                ", employmentHistory=" + employmentHistory +
                '}';
    }
}
