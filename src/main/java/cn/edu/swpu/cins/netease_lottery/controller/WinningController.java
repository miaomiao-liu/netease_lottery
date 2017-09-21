package cn.edu.swpu.cins.netease_lottery.controller;

import cn.edu.swpu.cins.netease_lottery.dao.WinningDao;
import cn.edu.swpu.cins.netease_lottery.model.persistence.WinningDetail;
import cn.edu.swpu.cins.netease_lottery.service.WinningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 中奖号码
 * Created by miaomiao on 17-7-28.
 */

@Controller
@RequestMapping("/customer/winning")
public class WinningController {

    @Autowired
    WinningService winningService;
//    @Autowired
//    MySchedule winningSchedule;
    @Autowired
    WinningDao winningDao;
    @Value("${NeteaseLottery.header}")
    private String id;


    @GetMapping("/generateNumber")
    public ResponseEntity<?> generateLotteryDetail(HttpServletRequest request){
        try{
//            winningSchedule.schedule();
            int winningId = request.getIntHeader(id);
//          WinningDetail winningDetail = winningService.addWinDetail();
            WinningDetail winningDetail = winningDao.selectWinningNumber(winningId);
            return new ResponseEntity<Object>(winningDetail, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }
    }

    @GetMapping("/lotteryList")
    public ResponseEntity getLotteryList(){
        try {
            List<WinningDetail> list = winningService.queryLotteryList();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }
    }


}
