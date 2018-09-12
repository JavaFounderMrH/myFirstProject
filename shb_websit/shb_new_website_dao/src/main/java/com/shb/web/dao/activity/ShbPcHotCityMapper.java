package com.shb.web.dao.activity;

import java.util.List;

import com.shb.web.mobile.activity.ShbPcHotCity;

public interface ShbPcHotCityMapper {
	
    ShbPcHotCity selectByPrimaryKey(Long id);

	List<ShbPcHotCity> queryShbPcHotCityList();


}