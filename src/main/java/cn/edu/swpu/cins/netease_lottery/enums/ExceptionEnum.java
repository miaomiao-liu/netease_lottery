package cn.edu.swpu.cins.netease_lottery.enums;

/**
 * Created by miaomiao on 17-8-3.
 */
public enum ExceptionEnum {
    INNER_ERROR("服务器内部异常！"),
    DATABASE_ERROR("数据库异常！");
    private String msg;

    ExceptionEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
