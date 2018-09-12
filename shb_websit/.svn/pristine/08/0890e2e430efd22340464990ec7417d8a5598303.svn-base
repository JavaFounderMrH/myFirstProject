package com.shb.web.api.user;

import com.shb.web.dto.user.UserInfoDto;
import com.shb.web.mobile.user.Recruit;
import com.shb.web.mobile.user.User;

public interface UserService {
	
    public User queryUser(User user);

	public int insertSelective(User record);
	
    Long updateUserPassword(User user);

	public UserInfoDto queryUserInfoByName(String username);

	public User selectByPrimaryKey(Long userId);
    
	public int updateByPrimaryKeySelective(User record);

	public int insertUserFeedback(Recruit recruit);
}
