package database.entity;

public class UserSkill {
    private int id;
    private int userId;
    private int skillId;
    private int power;

    public UserSkill() {
    }

    public UserSkill(int id, int userId, int skillId, int power) {
        this.id = id;
        this.userId = userId;
        this.skillId = skillId;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", userId=" + userId +
                ", skillId=" + skillId +
                ", power=" + power +
                '}';
    }
}
