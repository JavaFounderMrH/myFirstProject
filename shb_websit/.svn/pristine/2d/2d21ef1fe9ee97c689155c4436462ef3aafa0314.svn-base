package com.shb.web.service.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.activity.ShbRecommendedBitServcie;
import com.shb.web.dao.activity.ShbPcHotCityMapper;
import com.shb.web.dao.activity.ShbRecommendedBitMapper;
import com.shb.web.mobile.activity.ShbPcHotCity;
import com.shb.web.mobile.activity.ShbRecommendedBit;

@Service
public class ShbRecommendedBitServcieImpl implements ShbRecommendedBitServcie {

	@Autowired
	private ShbRecommendedBitMapper shbRecommendedBitMapper;

	@Autowired
	private ShbPcHotCityMapper shbPcHotCityMapper;

	@Override
	public ShbRecommendedBit selectByPrimaryKeyShbRecommendedBit(ShbRecommendedBit record) {
		return shbRecommendedBitMapper.selectByPrimaryKeyShbRecommendedBit(record);
	}

	@Override
	public ShbPcHotCity selectByPrimaryKey(Long id) {
		return shbPcHotCityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ShbRecommendedBit> queryShbRecommendedBitList(ShbRecommendedBit shbRecommendedBit) {

		return shbRecommendedBitMapper.queryShbRecommendedBitList(shbRecommendedBit);

	}

	@Override
	public List<ShbPcHotCity> queryShbPcHotCityList() {

		return shbPcHotCityMapper.queryShbPcHotCityList();

	}

}
