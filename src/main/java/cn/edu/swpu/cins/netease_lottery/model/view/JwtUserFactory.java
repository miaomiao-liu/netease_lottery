package cn.edu.swpu.cins.netease_lottery.model.view;

import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Date;

/**
 *类转换:CustomerInfo -> JwtUse
 * Created by miaomiao on 17-7-27.
 */
public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser createCustomer(CustomerInfo customerInfo){
        return new JwtUser(
                customerInfo.getId(),
                customerInfo.getPetName(),
                customerInfo.getPassword(),
                customerInfo.getEmail(),
                new Date(customerInfo.getLastPasswordResetDate()),
                //singletonList(T) 方法用于返回一个只包含指定对象的不可变列表
                Collections.singletonList(ToGrantedAuthorities(customerInfo.getRole()))
        );
    }

    private static GrantedAuthority ToGrantedAuthorities(String authorities) {
        return new SimpleGrantedAuthority(authorities);

    }
}
