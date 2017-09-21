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
    private WinningDao winningDao;

    @Override
    public void addWinDetail() throws WinningException {
        try {
            WinningDetail winningDetail = new WinningDetail();
            List<Integer> numbers = GenerateWinNumber.generateNumber();
            winningDetail.setWinNumber(numbers);
            winningDetail.setBigSmall(GenerateWinNumber.bigSmallCompare(numbers));
            winningDetail.setSingleDouble(GenerateWinNumber.singleDoubleCompare(numbers));
            winningDao.addLotteryDetail(winningDetail);
        }catch (Exception e){
            throw new WinningException(ExceptionEnum.DATABASE_ERROR.getMsg());
        }
    }

    @Override
    public List<WinningDetail> queryLotteryList() throws WinningException {

        try {
            List<WinningDetail> list = winningDao.selectWinningList();
            return list;
        }catch (Exception e) {
            throw new WinningException(ExceptionEnum.DATABASE_ERROR.getMsg());
        }
    }


}
