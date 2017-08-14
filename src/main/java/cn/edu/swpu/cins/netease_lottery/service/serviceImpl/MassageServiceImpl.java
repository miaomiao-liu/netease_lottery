package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.dao.MassageDao;
import cn.edu.swpu.cins.netease_lottery.model.persistence.Massage;
import cn.edu.swpu.cins.netease_lottery.service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by miaomiao on 17-8-13.
 */
@Service
public class MassageServiceImpl implements MassageService {

    @Autowired
    MassageDao massageDao;

    @Override
    public int addMassage(Massage massage) {
        return massageDao.addMassage(massage);
    }

    @Override
    public List<Massage> getConversationDatail(String conversationId) {
        return massageDao.getConversationDetail(conversationId);
    }
}
