package cn.edu.swpu.cins.netease_lottery.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by miaomiao on 17-7-27.
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable{
    private static final long serialVersionUID = 1L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "您没有通过验证，请重新登陆,并验证您的用户名和密码");
    }
}
