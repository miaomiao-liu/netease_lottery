package cn.edu.swpu.cins.netease_lottery.util;

import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;

@FunctionalInterface
public interface LotteryFunction {
    OrderIsWin handleLottery(OrderIsWin orderIsWin);
}
