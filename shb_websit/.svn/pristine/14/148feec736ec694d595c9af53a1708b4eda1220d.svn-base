package com.shb.web.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.shb.web.api.coupon.CouponService;
import com.shb.web.mobile.coupon.Coupon;

@Component
public class CouponType implements PhoteType {

	public static boolean resCoupon(Long id) {

		CouponService couponService = (CouponService) SpringUtil.getBean("couponService");
		
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = new Date();

		boolean bo = false;

		Coupon coupon = null;

		for (int i = 1; i <= 2; i++) {

			coupon = new Coupon();

			coupon.setPrice(20);

			coupon.setCreateTime(dateFormater.format(date));

			coupon.setModifyTime(dateFormater.format(date));

			coupon.setSuiRid(id);

			coupon.setOperator("王浩");

			coupon.setStartTime(dateFormater.format(date));

			coupon.setState(1);

			coupon.setSrc(phoneY20);

			coupon.setAshSrc(ashPhoneY20);

			coupon.setUseExplain("优惠券支持山海边APP预订使用，不可与其他优惠活动同享；");

			coupon.setName("注册体验券");

			Calendar calendar = Calendar.getInstance();

			Date dates = new Date(System.currentTimeMillis());

			calendar.setTime(dates);

			calendar.add(Calendar.YEAR, +1);

			dates = calendar.getTime();

			coupon.setEndTime(dateFormater.format(dates));

			coupon.setType(1);

			coupon.setTypeTitle("订单满200元可使用，每个订单限用一张优惠券;");

			couponService.insertSelective(coupon);

			bo = true;

		}

		for (int j = 1; j <= 2; j++) {

			coupon = new Coupon();

			coupon.setPrice(30);

			coupon.setCreateTime(dateFormater.format(date));

			coupon.setModifyTime(dateFormater.format(date));

			coupon.setOperator("王浩");

			coupon.setStartTime(dateFormater.format(date));

			coupon.setState(1);

			coupon.setSrc(phoneY30);

			coupon.setAshSrc(ashPhoneY30);

			coupon.setUseExplain("优惠券支持山海边APP预订使用，不可与其他优惠活动同享；");

			coupon.setName("注册体验券");

			coupon.setSuiRid(id);

			Calendar calendar = Calendar.getInstance();

			Date dates = new Date(System.currentTimeMillis());

			calendar.setTime(dates);

			calendar.add(Calendar.YEAR, +1);

			dates = calendar.getTime();

			coupon.setEndTime(dateFormater.format(dates));

			coupon.setType(1);

			coupon.setTypeTitle("订单满368元可使用，每个订单限用一张优惠券;");

			couponService.insertSelective(coupon);

			bo = true;

		}
		for (int k = 1; k <= 2; k++) {

			coupon = new Coupon();

			coupon.setPrice(50);

			coupon.setCreateTime(dateFormater.format(date));

			coupon.setModifyTime(dateFormater.format(date));

			coupon.setOperator("王浩");

			coupon.setStartTime(dateFormater.format(date));

			coupon.setState(1);

			coupon.setSuiRid(id);

			coupon.setSrc(phoneY50);

			coupon.setAshSrc(ashPhoneY50);

			coupon.setUseExplain("优惠券支持山海边APP预订使用，不可与其他优惠活动同享；");

			coupon.setName("注册体验券");

			Calendar calendar = Calendar.getInstance();

			Date dates = new Date(System.currentTimeMillis());

			calendar.setTime(dates);

			calendar.add(Calendar.YEAR, +1);

			dates = calendar.getTime();

			coupon.setEndTime(dateFormater.format(dates));

			coupon.setType(1);

			coupon.setTypeTitle("订单满618元可使用，每个订单限用一张优惠券;");

			couponService.insertSelective(coupon);

			bo = true;

		}
		return bo;
	}
}
