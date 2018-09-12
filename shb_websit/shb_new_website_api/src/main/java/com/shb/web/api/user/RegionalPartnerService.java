package com.shb.web.api.user;

import com.shb.web.mobile.user.RegionalPartner;

public interface RegionalPartnerService {

	Long insertSelective(RegionalPartner record);

    RegionalPartner selectByPrimaryName(String  userName);

    Long updateByPrimaryKeySelective(RegionalPartner record);
}
