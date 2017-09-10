package cn.edu.swpu.cins.netease_lottery.service;


import cn.edu.swpu.cins.netease_lottery.exception.WinningException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.WinningDetail;

import java.util.List;

/**
 * Created by miaomiao on 17-7-28.
 */
public interface WinningService {
    //生成中奖号码
//    List<Integer> generateLotteryNumber();

    //保存中奖号码及大小比
    void addWinDetail() throws WinningException;

//  int addWinDetail(WinningDetail winningDetail);

    List<WinningDetail> queryLotteryList() throws WinningException;
}


