package com.shb.web.api.room;


import java.util.List;

import com.shb.web.mobile.room.TradeareaOne;

public interface TradeareaOneService {

    TradeareaOne selectByPrimaryKey(Long stoId);
    
	List<TradeareaOne> queryTradeareaOne(String cityName, String areaCode);
   
}
