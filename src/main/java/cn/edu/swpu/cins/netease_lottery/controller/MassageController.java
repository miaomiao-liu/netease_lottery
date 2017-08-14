package cn.edu.swpu.cins.netease_lottery.controller;

import cn.edu.swpu.cins.netease_lottery.model.persistence.Massage;
import cn.edu.swpu.cins.netease_lottery.service.MassageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by miaomiao on 17-8-13.
 */

@Controller
@RequestMapping("/customer/msg")
public class MassageController {

    @Autowired
    MassageService massageService;

    @PostMapping("/addMassage")
    public ResponseEntity<?> addMassage(@RequestParam("fromId") int fromId,
                                        @RequestParam("toId") int toId,
                                        @RequestParam("content") String content) {
        try {
            Massage massage = new Massage();
            massage.setContent(content);
            massage.setFromId(fromId);
            massage.setToId(toId);
            massage.setCreateDate(new Date());
            massage.setConversationId(fromId < toId ? String.format("%d_%d", fromId, toId) : String.format("%d_%d", toId, fromId));
            if(massageService.addMassage(massage) == 0) {
                return new ResponseEntity<Object>("发送消息失败", HttpStatus.OK);
            }
             return new ResponseEntity<Object>(massage.getId(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>("发送消息失败",HttpStatus.OK);
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<?> ConversationDetail(@Param("conversationId") String conversationId){
        try {
            List<Massage> massages = massageService.getConversationDatail(conversationId);
            if(!massages.isEmpty()) {
                return new ResponseEntity<Object>(massages, HttpStatus.OK);
            }
            return new ResponseEntity<Object>("没有对话", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>("获取对话详情失败",HttpStatus.OK);
        }
    }
}
