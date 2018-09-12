package com.shb.web.web.coupon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/couponController")
public class CouponController {
	
	@Autowired  
	RestTemplate restTemplate;  
	 
	 // 线上 
	//private static String  ul = "http://www.shanhaibian.com/shb_weixin";
	private static String  ul = "http://192.168.3.106/shb_weixin";

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryCouponInfo")
	private Map<String, Object> queryCouponInfo(String username) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			
			String url = null;
			
			url = ul+"/coupon/queryCouponInfo?username="+username;
			
			map = restTemplate.getForEntity(url, Map.class).getBody();
			
			return map;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			return map;
			
		}
		
	}

}
