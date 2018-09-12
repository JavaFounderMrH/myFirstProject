package com.shb.web.dao.user;

import com.shb.web.mobile.user.LandlordInfo;
import com.shb.web.mobile.user.LandlordReceivables;

public interface LandlordInfoDao {

	LandlordInfo queryLandlordInfoByName(String username);

	LandlordInfo queryLandlordInfoById(Long sliId);

	LandlordReceivables queryLandlordReceivables(Long srid);

	Long updateByPrimaryKeySelective(LandlordInfo landlordInfo);

}
