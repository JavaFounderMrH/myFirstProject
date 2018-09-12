package com.shb.web.service.coupon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.coupon.CouponService;
import com.shb.web.dao.coupon.CouponDao;
import com.shb.web.mobile.coupon.Coupon;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponDao couponDao;

	@Override
	public Long deleteByPrimaryKey(Long scId) {
		return couponDao.deleteByPrimaryKey(scId);
	}

	@Override
	public Long insertSelective(Coupon record) {
		return couponDao.insertSelective(record);
	}

	@Override
	public Coupon selectByPrimaryKey(Long scId) {
		return couponDao.selectByPrimaryKey(scId);
	}

	@Override
	public Long updateByPrimaryKeySelective(Coupon record) {
		return couponDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Coupon> queryCouponInfo(Coupon record) {
		return couponDao.queryCouponInfo(record);
	}

}