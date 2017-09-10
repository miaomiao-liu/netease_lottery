package cn.edu.swpu.cins.netease_lottery.dao;

import cn.edu.swpu.cins.netease_lottery.model.persistence.WinningDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miaomiao on 17-7-26.
 */

@Repository
@Mapper
public interface WinningDao {

    //添加号码detail到中奖号码存储表
    int addLotteryDetail(WinningDetail winningDetail);

    WinningDetail selectWinningNumber(int id);

    List<WinningDetail> selectWinningList();
}
