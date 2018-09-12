package com.shb.web.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.user.UserService;
import com.shb.web.dto.user.UserInfoDto;
import com.shb.web.mobile.user.Recruit;
import com.shb.web.mobile.user.User;
import com.shb.web.dao.user.UserDao;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDao;

	@Override
	public User queryUser(User user) {
		
		return UserDao.queryUser(user);	
	}

	@Override
	public int insertSelective(User record) {
		return UserDao.insertSelective(record);
	}

	@Override
	public UserInfoDto queryUserInfoByName(String username) {
		return UserDao.queryUserInfoByName(username);
	}

	@Override
	public User selectByPrimaryKey(Long userId) {
		return UserDao.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return UserDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateUserPassword(User user) {
		return UserDao.updateUserPassword(user);
	}

	@Override
	public int insertUserFeedback(Recruit recruit) {
		
		return UserDao.insertUserFeedback(recruit);
	}
	
}
