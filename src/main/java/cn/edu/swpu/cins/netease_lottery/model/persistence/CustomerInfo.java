package cn.edu.swpu.cins.netease_lottery.model.persistence;

/**
 * Created by miaomiao on 17-7-26.
 */
public class CustomerInfo {
    private int id;
    private String petName;
    private String password;
    private String email;
    private String role;
    private long lastPasswordResetDate;

    public CustomerInfo() {
    }

    public CustomerInfo(int id, String petName, String password, String email, String role, long lastPasswordResetDate) {
        this.id = id;
        this.petName = petName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(long lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}
