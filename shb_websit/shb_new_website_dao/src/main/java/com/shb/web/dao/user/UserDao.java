package com.shb.web.dao.user;

import com.shb.web.dto.user.UserInfoDto;
import com.shb.web.mobile.user.Recruit;
import com.shb.web.mobile.user.User;

public interface UserDao {

	public User queryUser(User user);

	public int insertSelective(User record);

	public int updateByPrimaryKeySelective(User record);

	public Long updateUserPassword(User user);

	public UserInfoDto queryUserInfoByName(String username);

	public User selectByPrimaryKey(Long userId);

	User queryUser(String username);

	public int insertUserFeedback(Recruit recruit);

}
