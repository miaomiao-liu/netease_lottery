package cn.edu.swpu.cins.netease_lottery.enums;

/**
 * Created by miaomiao on 17-8-3.
 */
public enum LoginEnum {
    NO_USER("该用户名不存在");
    private String msg;

    LoginEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
