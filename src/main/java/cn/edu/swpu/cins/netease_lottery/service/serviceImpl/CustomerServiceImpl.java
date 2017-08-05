package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.config.JwtTokenUtil;
import cn.edu.swpu.cins.netease_lottery.dao.CustomerDao;
import cn.edu.swpu.cins.netease_lottery.enums.ExceptionEnum;
import cn.edu.swpu.cins.netease_lottery.exception.CustomerException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.JwtUserFactory;
import cn.edu.swpu.cins.netease_lottery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import javax.naming.AuthenticationNotSupportedException;
import java.util.Date;

/**
 * Created by miaomiao on 17-7-26.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Override
    public int addCustomer(CustomerInfo customerInfo) throws CustomerException {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            final String rawPassword = customerInfo.getPassword();
            customerInfo.setPassword(encoder.encode(rawPassword));
            customerInfo.setLastPasswordResetDate(new Date().getTime());
            customerInfo.setRole("CUSTOMER");
            return customerDao.addCustomer(customerInfo);
        }catch (Exception e){
            throw new CustomerException(ExceptionEnum.DATABASE_ERROR.getMsg());
        }

    }


    @Override
    public String loginCustomer(String petName,String password) throws CustomerException{
        try{
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(petName,password);
            final Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final UserDetails userDetails = JwtUserFactory.createCustomer(customerDao.selectByPetName(petName));
            final String token = jwtTokenUtil.generateToken(userDetails);
            return token;
        }catch (Exception e){
            throw new CustomerException(ExceptionEnum.INNER_ERROR.getMsg());
        }

    }
}