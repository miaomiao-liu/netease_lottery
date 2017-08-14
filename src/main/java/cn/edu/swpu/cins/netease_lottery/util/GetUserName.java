package cn.edu.swpu.cins.netease_lottery.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 从request中获取用户名
 * Created by miaomiao on 17-7-27.
 */
@Component
public class GetUserName {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Value("${jwt.header}")
    private String tokenheader;
    
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    
    public String getUsernameFromRequest(HttpServletRequest request){
        
        String header = request.getHeader(this.tokenheader);
        final String token = header.substring(tokenHead.length());
        return jwtTokenUtil.getUsernameFromToken(token);
    }
    
}
