package com.shb.web.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/touristRouteApi")
public class TouristRouteContreoller {
	
	 @Autowired  
	 RestTemplate restTemplate;  
	 
	 // 线上 
	private static String  ul = "http://www.shanhaibian.com/shb_weixin";
	//private static String  ul = "http://192.168.3.128/shb_weixin";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/querytouristRouteInfo")
    private Map<String,Object> querytouristRouteInfo(HttpServletRequest request,String query) throws IOException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		String url = ul+"/tourismLineController/selectTourismLineList";  
		
		 map = restTemplate.getForEntity(url, Map.class).getBody();  
		 
		
		// map = restTemplate.postForEntity(url,RequestMethod.POST,Map.class).getBody();
     return map;  
	 
	 
	 
}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/querytouristRouteInfoByLineId")
    private Map<String,Object> querytouristRouteInfoByLineId(HttpServletRequest request,Long lineId) throws IOException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		String url = ul+"/tourismLineController/pcSelectTourismLineDetailsByLineId?lineId="+lineId;  
		
		 map = restTemplate.getForEntity(url, Map.class).getBody();  
		 
		
		// map = restTemplate.postForEntity(url,RequestMethod.POST,Map.class).getBody();
     return map;  
	 
	 
	 
}

}
