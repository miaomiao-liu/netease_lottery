package cn.edu.swpu.cins.netease_lottery.enums;

/**
 * Created by miaomiao on 17-7-26.
 */
public enum RegisterEnum {

    REPEAT_USERNAME("该用户名已被注册"),
    REPEAT_EMAIL("该邮箱已被注册"),
    SUCCESS_SAVE("注册成功"),
    FAIL_SAVE("注册失败");

    private String msg;

    RegisterEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
