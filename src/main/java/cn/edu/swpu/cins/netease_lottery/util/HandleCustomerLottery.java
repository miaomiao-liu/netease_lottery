package cn.edu.swpu.cins.netease_lottery.util;

import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by miaomiao on 17-7-29.
 */
@Component
public class HandleCustomerLottery {

    public OrderIsWin handleLottery(OrderList orderList,
                                    List<Integer> winNumber,
                                    int multiple){

        String lotteryName = orderList.getLotteryName();
        List<Integer> lotteryNumber = orderList.getLotteryNumber();

        OrderIsWin orderIsWin=new OrderIsWin();
        //与中奖号码的匹配数


        int wins=0;
        int winGrade=0;
        int winMoney=0;
        int numberNum = 0;

        for(int num : lotteryNumber){
           for(int winNum:winNumber ){
               if(num == winNum){
                   wins++;
               }
           }
            numberNum++;
        }

        //如果玩法为“任二”
        if(lotteryName.equals("任二")){
            if(wins >= 2){
                orderIsWin.setIsWin("是");
                for(wins--; wins > 0; wins--){
                    winGrade += wins;
                }
                winMoney = 6*winGrade*multiple;
                orderIsWin.setWinGrade(winGrade);
                orderIsWin.setWinMoney(winMoney);
            }else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //如果玩法为“任三“
        if(lotteryName.equals("任三")) {
            if (wins >= 3) {
                winGrade = wins * (wins - 1) * (wins - 2) / 6;
                winMoney = 19 * winGrade * multiple;
                orderIsWin.setIsWin("是");
                orderIsWin.setWinGrade(winGrade);
                orderIsWin.setWinMoney(winMoney);
            } else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //如果玩法为“任四”
        if(lotteryName.equals("任四")){
            if(wins >= 4){
                if(wins==4) {
                    orderIsWin.setWinGrade(1);
                    orderIsWin.setWinMoney(78);
                }
                if(wins==5){
                    orderIsWin.setWinGrade(5);
                    orderIsWin.setWinMoney(390);
                }
                orderIsWin.setIsWin("是");
            }else {
            orderIsWin.setIsWin("否");
            orderIsWin.setWinGrade(0);
            orderIsWin.setWinMoney(0);
            }
        }

        //任五
        if(lotteryName.equals("任五")) {
            if (wins == 5) {
                winMoney = 540 * multiple;
                orderIsWin.setIsWin("是");
                orderIsWin.setWinGrade(1);
                orderIsWin.setWinMoney(winMoney);
            } else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //任六
        if(lotteryName.equals("任六")) {
            if (wins == 5) {
                for (; numberNum > 5; numberNum--) {
                    winGrade++;
                }
                winMoney = 90 * winGrade * multiple;
                orderIsWin.setWinMoney(winMoney);
                orderIsWin.setIsWin("是");
                orderIsWin.setWinGrade(winGrade);
            } else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //任七
        if(lotteryName.equals("任七")) {
            if (wins == 5) {
                numberNum = numberNum - 6;
                for (; numberNum > 0; numberNum--) {
                    winGrade += numberNum;
                }
                winMoney = 26 * winGrade * multiple;
                orderIsWin.setWinMoney(winMoney);
                orderIsWin.setIsWin("是");
                orderIsWin.setWinGrade(winGrade);
            } else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //任八
        if(lotteryName.equals("任八")){
            if(wins==5){
                if(numberNum == 8){
                    winGrade = 1;
                }else if(numberNum == 9){
                    winGrade = 4;
                }else if(numberNum ==10){
                    winGrade = 10;
                }else if(numberNum ==11){
                    winGrade = 20;
                }
                winMoney = 9*winGrade*multiple ;
                orderIsWin.setWinMoney(winMoney);
                orderIsWin.setIsWin("是");
                orderIsWin.setWinGrade(winGrade);
            }else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //前一
        if(lotteryName.equals("前一")){
            int count = 0;
            int firstNum = winNumber.get(0);
            for(int num : lotteryNumber){
                if(num == firstNum){
                    count++;
                }
            }
            if(count==1){
                winMoney = 13*multiple;
                orderIsWin.setWinMoney(winMoney);
                orderIsWin.setWinGrade(1);
                orderIsWin.setIsWin("是");
            }else {
                orderIsWin.setIsWin("否");
                orderIsWin.setWinGrade(0);
                orderIsWin.setWinMoney(0);
            }
        }

        //前二组选
        if(lotteryName.equals("前二组选")){
            if(wins==2){
                winMoney = 65*multiple;
                orderIsWin.setWinMoney(winMoney);
                orderIsWin.setIsWin("是");
                orderIsWin.setWinGrade(1);
            }
            orderIsWin.setIsWin("否");
            orderIsWin.setWinGrade(0);
            orderIsWin.setWinMoney(0);
        }


        //前二直选
//        if(){
//
//        }
//

        //前三组选
       if(lotteryName.equals("前三组选")){
        if(wins==3){
            winMoney = 195*multiple;
            orderIsWin.setWinMoney(winMoney);
            orderIsWin.setIsWin("是");
            orderIsWin.setWinGrade(1);
        }
        orderIsWin.setIsWin("否");
        orderIsWin.setWinGrade(0);
        orderIsWin.setWinMoney(0);
        }


//        前三直选
//        if(){
//
//        }


        return orderIsWin;
    }
}
