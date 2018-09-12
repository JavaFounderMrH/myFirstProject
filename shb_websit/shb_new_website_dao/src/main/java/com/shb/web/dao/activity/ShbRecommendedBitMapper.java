package com.shb.web.dao.activity;

import java.util.List;

import com.shb.web.mobile.activity.ShbRecommendedBit;

public interface ShbRecommendedBitMapper {
	
    ShbRecommendedBit selectByPrimaryKeyShbRecommendedBit(ShbRecommendedBit record);

	List<ShbRecommendedBit> queryShbRecommendedBitList(ShbRecommendedBit shbRecommendedBit);

}