package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.dao.WinningDao;
import cn.edu.swpu.cins.netease_lottery.enums.ExceptionEnum;
import cn.edu.swpu.cins.netease_lottery.exception.WinningException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.WinningDetail;
import cn.edu.swpu.cins.netease_lottery.service.WinningService;
import cn.edu.swpu.cins.netease_lottery.util.GenerateWinNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by miaomiao on 17-7-28.
 */

@Service
public class WinningServiceImpl implements WinningService {
    @Autowired
    private GenerateWinNumber generateWinNumber;
    @Autowired
    private WinningDao winningDao;


    @Override
    public WinningDetail addWinDetail() throws WinningException {
        try {
            WinningDetail winningDetail = new WinningDetail();
            List<Integer> numbers = generateWinNumber.generateNumber();
            winningDetail.setWinNumber(numbers);
            winningDetail.setBigSmall(generateWinNumber.bigSmallCompare(numbers));
            winningDao.addLotteryDetail(winningDetail);
            return winningDetail;
        }catch (Exception e){
            throw new WinningException(ExceptionEnum.DATABASE_ERROR.getMsg());
        }
    }
}
