package com.shb.web.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.user.UserLogService;
import com.shb.web.dao.user.UserLogMapper;
import com.shb.web.mobile.user.BaseUserLog;


@Service
public class UserLogServiceImpl implements UserLogService {

	@Autowired
	private UserLogMapper logMapper;
	
	@Override
	public Boolean insertUserLog(BaseUserLog baseUserLog) {
		BaseUserLog userLog = logMapper.selectByUserId(baseUserLog.getUser_id());
		if(userLog!=null) {
			return logMapper.updateByPrimaryKeySelective(baseUserLog)>0;
		}else {
			
			return logMapper.insert(baseUserLog)>0;
		}
	}

	

}
