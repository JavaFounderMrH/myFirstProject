package com.shb.web.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.user.RegionalPartnerService;
import com.shb.web.dao.user.RegionalPartnerDao;
import com.shb.web.mobile.user.RegionalPartner;

@Service
public class RegionalPartnerServiceImpl implements RegionalPartnerService {

	@Autowired
	private RegionalPartnerDao regionalPartnerDao;

	@Override
	public Long insertSelective(RegionalPartner record) {
		return regionalPartnerDao.insertSelective(record);
	}

	@Override
	public RegionalPartner selectByPrimaryName(String userName) {
		return regionalPartnerDao.selectByPrimaryName(userName);
	}

	@Override
	public Long updateByPrimaryKeySelective(RegionalPartner record) {
		return regionalPartnerDao.updateByPrimaryKeySelective(record);
	}

}
