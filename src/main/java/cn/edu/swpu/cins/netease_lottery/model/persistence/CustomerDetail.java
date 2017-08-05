package cn.edu.swpu.cins.netease_lottery.model.persistence;

/**
 * Created by miaomiao on 17-7-26.
 */
public class CustomerDetail {
    private int id;
    private String username;
    private int infoId;
    private String sex;
    private int age;

    public CustomerDetail(int id, String username, int infoId, String sex, int age) {
        this.id = id;
        this.username = username;
        this.infoId = infoId;
        this.sex = sex;
        this.age = age;
    }

    public CustomerDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
