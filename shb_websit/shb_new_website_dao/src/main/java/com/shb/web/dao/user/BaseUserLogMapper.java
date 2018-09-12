package com.shb.web.dao.user;

import com.shb.web.mobile.user.BaseUserLog;

public interface BaseUserLogMapper {

	int deleteByPrimaryKey(Long id);

	int insert(BaseUserLog record);

	int insertSelective(BaseUserLog record);

	BaseUserLog selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(BaseUserLog record);

	int updateByPrimaryKey(BaseUserLog record);
}