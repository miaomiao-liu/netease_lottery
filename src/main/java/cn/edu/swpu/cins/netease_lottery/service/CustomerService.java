package cn.edu.swpu.cins.netease_lottery.service;

import cn.edu.swpu.cins.netease_lottery.exception.CustomerException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerInfo;

/**
 * Created by miaomiao on 17-7-27.
 */
public interface CustomerService {

    //注册，增加一个用户记录
    public int addCustomer(CustomerInfo customerInfo) throws CustomerException;
    //登录，用户登录鉴权
    public String loginCustomer(String petName,String password) throws CustomerException;
}
