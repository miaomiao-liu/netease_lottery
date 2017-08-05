package cn.edu.swpu.cins.netease_lottery.controller;

import cn.edu.swpu.cins.netease_lottery.model.persistence.WinningDetail;
import cn.edu.swpu.cins.netease_lottery.service.WinningService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 中奖号码   可能不需要?
 * Created by miaomiao on 17-7-28.
 */

@Controller
@RequestMapping("/customer/winning")
public class WinningController {

    @Autowired
    WinningService winningService;

    @GetMapping("/generateNumber")
    public ResponseEntity<?> generateLotteryDetail(){
        try{
            WinningDetail winningDetail = winningService.addWinDetail();
            return new ResponseEntity<Object>(winningDetail, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }
    }
}
