package com.shb.web.service.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.city.CityService;
import com.shb.web.dao.city.CityDao;
import com.shb.web.dto.city.CityInfoDto;

@Service
public class CityServicImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	@Override
	public List<CityInfoDto> queryCityProvince() {
		return cityDao.queryCityProvince();
	}

	@Override
	public List<CityInfoDto> queryCityArea(String province) {
		return cityDao.queryCityArea(province);
	}

}
