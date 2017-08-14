package cn.edu.swpu.cins.netease_lottery.service;

import cn.edu.swpu.cins.netease_lottery.model.persistence.Massage;

import java.util.List;

/**
 * Created by miaomiao on 17-8-13.
 */
public interface MassageService {

    public int addMassage(Massage massage);

    public List<Massage> getConversationDatail(String conversationId);
}
