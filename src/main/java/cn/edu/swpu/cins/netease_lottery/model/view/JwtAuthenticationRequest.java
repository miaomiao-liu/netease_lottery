package cn.edu.swpu.cins.netease_lottery.model.view;

import java.io.Serializable;

/**
 * Created by miaomiao on 17-7-27.
 */
public class JwtAuthenticationRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private String password;
    private String petName;

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(String password, String petName) {
        this.password = password;
        this.petName = petName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
