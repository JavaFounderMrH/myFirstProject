package com.shb.web.api.city;

import java.util.List;

import com.shb.web.dto.city.CityInfoDto;

public interface CityService {

	/**
	 * 查询省
	 */
	List<CityInfoDto> queryCityProvince();

	/**
	 * 查询市
	 */
	List<CityInfoDto> queryCityArea(String province);
}
