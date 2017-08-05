package cn.edu.swpu.cins.netease_lottery.model.view;

import java.io.Serializable;

/**
 * Created by miaomiao on 17-7-27.
 */
public class JwtAuthenticationResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String token;
    private String role;
    private String petName;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(int id, String token, String role, String petName) {
        this.id = id;
        this.token = token;
        this.role = role;
        this.petName = petName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }


}
