package com.shb.web.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.user.NewsPushService;
import com.shb.web.dao.user.NewsPushDao;
import com.shb.web.mobile.user.NewsPush;


@Service
public class NewsPushServiceImpl implements NewsPushService {

	@Autowired
	private NewsPushDao newsPushDao;

	@Override
	public Long insertSelective(NewsPush newsPush) {
		return newsPushDao.insertSelective(newsPush);
	}
}
