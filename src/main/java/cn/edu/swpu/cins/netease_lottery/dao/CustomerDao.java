package cn.edu.swpu.cins.netease_lottery.dao;

import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 17-7-26.
 */

@Repository
@Mapper
public interface CustomerDao {


    /**
     * customer_info
     */
    //昵称查找
    public CustomerInfo selectByPetName(String petName);
    //邮箱查找
    public CustomerInfo selectByEmail(String email);
    //添加用户
    public int addCustomer(CustomerInfo customerInfo);


    /**
     * customer_detail
     */
    //根据infoId查找
    public CustomerDetail selectDetailByInfoId(int infoId);
    //添加个人信息
    public int addCustomerDetail(CustomerDetail customerDetail);
    //更新用户个人信息
    public int updateCustomerDetail(CustomerDetail customerDetail);
}
