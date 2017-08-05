package cn.edu.swpu.cins.netease_lottery.controller;

import cn.edu.swpu.cins.netease_lottery.dao.CustomerDao;
import cn.edu.swpu.cins.netease_lottery.enums.CustomerEnum;
import cn.edu.swpu.cins.netease_lottery.enums.LoginEnum;
import cn.edu.swpu.cins.netease_lottery.enums.RegisterEnum;
import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.CustomerInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.JwtAuthenticationRequest;
import cn.edu.swpu.cins.netease_lottery.model.view.JwtAuthenticationResponse;
import cn.edu.swpu.cins.netease_lottery.service.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by miaomiao on 17-7-26.
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerServiceImpl customerService;

    // order_info 订单id
    @Value("${NeteaseLottery.header}")
    private String id;


    //注册
    @PostMapping("/register")
    public ResponseEntity<?> customerRegister(@RequestBody CustomerInfo customerInfo){
        try {
            if(customerDao.selectByPetName(customerInfo.getPetName()) != null)
                return new ResponseEntity<Object>(RegisterEnum.REPEAT_USERNAME.getMsg(), HttpStatus.OK);
            if(customerDao.selectByEmail(customerInfo.getEmail()) !=null)
                return new ResponseEntity<Object>(RegisterEnum.REPEAT_EMAIL.getMsg(),HttpStatus.OK);
            if(customerService.addCustomer(customerInfo) == 1)
                return new ResponseEntity<Object>(RegisterEnum.SUCCESS_SAVE.getMsg(),HttpStatus.OK);
            return new ResponseEntity<Object>(RegisterEnum.FAIL_SAVE.getMsg(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }
    }

    //登录
    @PostMapping("/login")
    public ResponseEntity<?> customerLogin(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest){
        try{
            CustomerInfo customerInfo= customerDao.selectByPetName(jwtAuthenticationRequest.getPetName());
            if(customerInfo == null )
                return new ResponseEntity<Object>(LoginEnum.NO_USER.getMsg(),HttpStatus.OK);
            String token = customerService.loginCustomer(jwtAuthenticationRequest.getPetName(), jwtAuthenticationRequest.getPassword());
            int infoId = customerInfo.getId();
            String role = customerInfo.getRole();
            String petName = customerInfo.getPetName();
            return new ResponseEntity<Object>(new JwtAuthenticationResponse(infoId,token,role,petName),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }

    }

    //编辑个人资料
    @PostMapping("/editCustomerDetail")
    public ResponseEntity<?> editCustomerDetail(@RequestBody CustomerDetail customerDetail,
                                                HttpServletRequest request) {
        customerDetail.setInfoId(request.getIntHeader(id));
        if (customerDao.selectDetailByInfoId(request.getIntHeader(id)) == null) {
            if (customerDao.addCustomerDetail(customerDetail) != 0)
                return new ResponseEntity<Object>(CustomerEnum.SUCCESS_ADD_PERSONAL.getMsg(), HttpStatus.OK);
            return new ResponseEntity<Object>(CustomerEnum.FAIL_ADD_PERSONAL.getMsg(), HttpStatus.OK);
        } else {
            if (customerDao.updateCustomerDetail(customerDetail) != 0)
                return new ResponseEntity<Object>(CustomerEnum.SUCCESS_UPDATE_PERSONAL.getMsg(), HttpStatus.OK);
            return new ResponseEntity<Object>(CustomerEnum.FAIL_UPDATE_PERSONAL.getMsg(), HttpStatus.OK);
        }
    }

    //查看个人资料
    @GetMapping("queryCustomerDetail")
    public ResponseEntity<?> queryCustomerDetail(HttpServletRequest request){
        if(customerDao.selectDetailByInfoId(request.getIntHeader(id)) != null){
            CustomerDetail customerDetail = customerDao.selectDetailByInfoId(request.getIntHeader(id));
            return new ResponseEntity<Object>(customerDetail,HttpStatus.OK);
        }
        return new ResponseEntity<Object>(CustomerEnum.FAIL_QUERY_PERSONAL.getMsg(),HttpStatus.OK);
    }

}
