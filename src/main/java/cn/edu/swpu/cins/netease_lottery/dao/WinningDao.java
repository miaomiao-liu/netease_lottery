package cn.edu.swpu.cins.netease_lottery.dao;

import cn.edu.swpu.cins.netease_lottery.model.persistence.WinningDetail;
import cn.edu.swpu.cins.netease_lottery.service.WinningService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 17-7-26.
 */

@Repository
@Mapper
public interface WinningDao {

    //添加号码detail到中奖号码存储表
    public int addLotteryDetail(WinningDetail winningDetail);

    public WinningDetail selectWinningNumber(int id);
}
