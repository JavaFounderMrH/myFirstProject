package com.shb.web.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.redis.RedisService;
import com.shb.web.api.user.LandlordInfoService;
import com.shb.web.dao.user.LandlordInfoDao;
import com.shb.web.mobile.user.LandlordInfo;
import com.shb.web.mobile.user.LandlordReceivables;

@Service
public class LandlordInfoServiceImpl implements LandlordInfoService {

	@Autowired
	private LandlordInfoDao landlordInfoDao;

	@Autowired
	private RedisService redisService;

	@Override
	public LandlordInfo queryLandlordInfoById(Long sliId) {

		LandlordInfo landlordInfo = null;

		landlordInfo = (LandlordInfo) redisService.get("LANDLORDINFO_" + sliId);

		if (landlordInfo == null) {

			landlordInfo = landlordInfoDao.queryLandlordInfoById(sliId);

			redisService.set("LANDLORDINFO_" + sliId, landlordInfo);

			redisService.expire("LANDLORDINFO_" + sliId, 60 * 60 * 24L);

		}

		return landlordInfo;
		
	}

	@Override
	public LandlordInfo queryLandlordInfoByName(String username) {
		return landlordInfoDao.queryLandlordInfoByName(username);
	}

	@Override
	public Long updateByPrimaryKeySelective(LandlordInfo landlordInfo) {
		return landlordInfoDao.updateByPrimaryKeySelective(landlordInfo);
	}

	@Override
	public LandlordReceivables queryLandlordReceivables(Long srid) {
		return landlordInfoDao.queryLandlordReceivables(srid);
	}

}
