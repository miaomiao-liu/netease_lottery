package cn.edu.swpu.cins.netease_lottery.util;

import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;
import cn.edu.swpu.cins.netease_lottery.model.view.PreOrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by miaomiao on 17-7-29.
 */
@Component
public class HandleCustomerLottery {

    public OrderIsWin handleLottery(OrderIsWin orderIsWin,LotteryFunction lotteryFunction){
        return lotteryFunction.handleLottery(orderIsWin);
    }

    public OrderIsWin handleLottery(PreOrderDetail preOrderDetail,
                                List<Integer> winNumbers){
        String lotteryName = preOrderDetail.getLotteryName();
        List<Integer> lotteryNumber = preOrderDetail.getLotteryNumber();
        final int multiple = preOrderDetail.getMultiple();
        OrderIsWin orderIsWin = new OrderIsWin();
        //与中奖号码的匹配数
        int wins = 0;
        for(int num : lotteryNumber){
            for(int winNum : winNumbers ){
                if(num == winNum){
                    wins++;
                }
            }
        }

        orderIsWin.setIsWin("否");
        //本号码中了几注
        orderIsWin.setWinGrade(0);
        orderIsWin.setWinMoney(0);
        orderIsWin.setWins(wins);

        //如果玩法为“任二”
        if(lotteryName.equals("任二")){
            return handleLottery(orderIsWin,(handled) -> {
                int matches = handled.getWins();
                int winGrade = handled.getWinGrade();
                if(matches >= 2){
                    handled.setIsWin("是");
                    for(matches--; matches > 0; matches--){
                        winGrade += matches;
                    }
                    handled.setWinGrade(winGrade);
                    handled.setWinMoney(6 * winGrade * multiple);
                }
                return handled;
            });
        }

        //如果玩法为“任三“
        if(lotteryName.equals("任三")) {
            return handleLottery(orderIsWin,(handled) -> {
                int matches = handled.getWins();
                int winGrade;
                if (matches >= 3) {
                    winGrade = matches * (matches - 1) * (matches - 2) / 6;
                    handled.setIsWin("是");
                    handled.setWinGrade(winGrade);
                    handled.setWinMoney(19 * winGrade * multiple);
                }
                return handled;
            });

        }

        //如果玩法为“任四”
        if(lotteryName.equals("任四")){
            return handleLottery(orderIsWin,(handled) -> {
                int matches = handled.getWins();
                if(matches >= 4){
                    if(matches==4) {
                        handled.setWinGrade(1);
                        handled.setWinMoney(78);
                    }
                    if(matches==5){
                        handled.setWinGrade(5);
                        handled.setWinMoney(390);
                    }
                    handled.setIsWin("是");
                }
                return handled;
            });

        }

        //任五
        if(lotteryName.equals("任五")) {
            return handleLottery(orderIsWin,(handled) -> {
                int matches = handled.getWins();
                if (matches == 5) {
                    handled.setIsWin("是");
                    handled.setWinGrade(1);
                    handled.setWinMoney(540 * multiple);
                }
                return handled;
            });
        }

        //任六
        if(lotteryName.equals("任六")) {
            return handleLottery(orderIsWin,(handled) ->{
                int matches = handled.getWins();
                int winGrade = handled.getWinGrade();
                int numberNum = lotteryNumber.size();
                if (matches == 5) {
                    for (; numberNum > 5; numberNum--) {
                        winGrade++;
                    }
                    handled.setWinMoney(90 * winGrade * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(winGrade);
                }
                return handled;
            });
        }

        //任七
        if(lotteryName.equals("任七")) {
            return handleLottery(orderIsWin,(handled) ->{
                int matches = handled.getWins();
                int winGrade = handled.getWinGrade();
                int numberNum = lotteryNumber.size();
                if (matches == 5) {
                    numberNum = numberNum - 6;
                    for (; numberNum > 0; numberNum--) {
                        winGrade += numberNum;
                    }
                    handled.setWinMoney(26 * winGrade * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(winGrade);
                }
                return handled;
            });

        }

        //任八
        if(lotteryName.equals("任八")){
            return handleLottery(orderIsWin,(handled) -> {
                int matches = handled.getWins();
                int winGrade = handled.getWinGrade();
                int numberNum = lotteryNumber.size();
                if(matches==5){
                    if(numberNum == 8){
                        winGrade = 1;
                    }else if(numberNum == 9){
                        winGrade = 4;
                    }else if(numberNum ==10){
                        winGrade = 10;
                    }else if(numberNum ==11){
                        winGrade = 20;
                    }
                    handled.setWinMoney(9 * winGrade * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(winGrade);
                }
                return handled;
            });
        }

        //前一
        if(lotteryName.equals("前一")){
            return handleLottery(orderIsWin,(handled) ->{
                int count = 0;
                int firstNum = winNumbers.get(0);
                for(int num : lotteryNumber){
                    if(num == firstNum){
                        count++;
                    }
                }
                if(count==1){
                    handled.setWinMoney(13 * multiple);
                    handled.setWinGrade(1);
                    handled.setIsWin("是");
                }
                return handled;
            });
        }



        List<Integer> preTwo = winNumbers.subList(0,2);
        //前二组选
        if(lotteryName.equals("前二组选")) {
            return handleLottery(orderIsWin,(handled) -> {
                int matches = 0;
                for (int num : lotteryNumber) {
                    for (int winNum : preTwo) {
                        if (num == winNum) {
                            matches++;
                        }
                    }
                }
                if (matches == 2) {
                    handled.setWinMoney(65 * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(1);
                }
                return handled;
            });

        }


        //前二直选
        if(lotteryName.equals("前二直选")){
            return handleLottery(orderIsWin,(handled) ->{
                int matches = 0;
                int i = 0;
                for (int winNum : preTwo){
                    for (;i < lotteryNumber.size(); i++) {
                        if (winNum == lotteryNumber.get(i)) {
                            matches++;
                            break;
                        }
                    }
                    i++;
                }
                if(matches==2){
                    handled.setWinMoney(130 * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(1);
                }
                return handled;
            });

        }


        List<Integer> preThree = winNumbers.subList(0, 3);
        //前三组选
        if(lotteryName.equals("前三组选")) {
            return  handleLottery(orderIsWin,(handled) -> {
                int matches = 0;
                for (int num : lotteryNumber) {
                    for (int winNum : preThree) {
                        if (num == winNum) {
                            matches++;
                        }
                    }
                }
                if (matches == 3) {
                    handled.setWinMoney(195 * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(1);
                }
                return handled;
            });

        }


        //前三直选
        if(lotteryName.equals("前三直选")){
            return handleLottery(orderIsWin,(handled) ->{
                int matches = 0;
                int i = 0;
                for (int winNum : preThree){
                    for (;i < lotteryNumber.size(); i++) {
                        if (winNum == lotteryNumber.get(i)) {
                            matches++;
                            break;
                        }
                    }
                    i++;
                }
                if(matches==3){
                    handled.setWinMoney(1170 * multiple);
                    handled.setIsWin("是");
                    handled.setWinGrade(1);
                }
                return handled;
            });
        }
        return orderIsWin;

    }
}
