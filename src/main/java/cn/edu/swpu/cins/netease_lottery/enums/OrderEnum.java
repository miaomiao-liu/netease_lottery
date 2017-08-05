package cn.edu.swpu.cins.netease_lottery.enums;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Created by miaomiao on 17-8-3.
 */
public enum  OrderEnum {
    FAIL_ADD_ORDER("添加订单失败");

    private String msg;

    OrderEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
