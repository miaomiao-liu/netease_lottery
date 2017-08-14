package cn.edu.swpu.cins.netease_lottery.dao;

import cn.edu.swpu.cins.netease_lottery.model.persistence.Massage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Param("conversationId")
 * @Param("offset") int  offset,
 @Param("limit") int limit
 * Created by miaomiao on 17-8-13.
 */
@Mapper
public interface MassageDao {

    int addMassage(Massage massage);

    List<Massage> getConversationDetail(String conversationId);
}
