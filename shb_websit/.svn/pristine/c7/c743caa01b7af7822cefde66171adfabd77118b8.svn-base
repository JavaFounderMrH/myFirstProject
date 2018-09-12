package com.shb.web.web.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shb.web.api.coupon.CouponService;
import com.shb.web.service.coupon.CouponServiceImpl;

@Configuration
public class AppConfig {

	@Bean("imageDir")
	public String imageDir() {

		return new String("image");
	}

	@Bean("couponService")
	public CouponService couponService() {

		return new CouponServiceImpl();
	}
}
