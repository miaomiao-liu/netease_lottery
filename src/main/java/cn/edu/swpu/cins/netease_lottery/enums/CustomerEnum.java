package cn.edu.swpu.cins.netease_lottery.enums;

/**
 * Created by miaomiao on 17-8-3.
 */
public enum CustomerEnum {
    SUCCESS_ADD_PERSONAL("添加用户个人信息成功"),
    FAIL_ADD_PERSONAL("添加用户个人信息失败"),
    SUCCESS_UPDATE_PERSONAL("更新用户个人信息成功"),
    FAIL_UPDATE_PERSONAL("更新用户个人信息失败"),
    FAIL_QUERY_PERSONAL("查询个人信息失败");

    private String msg;

    CustomerEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
