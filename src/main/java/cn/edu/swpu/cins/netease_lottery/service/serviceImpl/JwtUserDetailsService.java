package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.dao.CustomerDao;
import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 从用户名查到用户
 * Created by miaomiao on 17-7-27.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomerInfo customerInfo = customerDao.selectByPetName(username);
        if(customerInfo !=null && customerInfo.getRole().equalsIgnoreCase("CUSTOMER"))
            return JwtUserFactory.createCustomer(customerInfo);
        return null;
    }
}
