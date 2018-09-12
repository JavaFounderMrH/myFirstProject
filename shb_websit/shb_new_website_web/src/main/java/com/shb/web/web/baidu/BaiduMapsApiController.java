package com.shb.web.web.baidu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shb.web.web.util.HttpRequester;
import com.shb.web.web.util.HttpRespons;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("baiduMapsApi")
public class BaiduMapsApiController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/querybaiduMapsApiIp",method = RequestMethod.GET)
	private Map<String,Object> querybaiduMapsApiIp(String ip){
		
		Map<String,Object> map = new  HashMap<String,Object>();
		
		HttpRequester requests = new HttpRequester();

		requests.setDefaultContentEncoding("utf-8");
		
		try {
			
			if (ip!=null && ip!=""){
				
				String url = "http://api.map.baidu.com/location/ip?ip="+ip+"&ak=3YPPin9aZ5aNqoYLwCRV1OIlg7iuAqC5";
				
				HttpRespons hr = requests.sendGet(url);

				String ress = hr.getContent();
				
				JSONObject jsonMap  = JSONObject.fromObject(ress);
				
				 Map<String, Object> maps = new HashMap<String, Object>();  
				 
			    Iterator<String> it = jsonMap.keys();  
			    
			    while(it.hasNext()) {  
			    	
			        String key = (String) it.next();  
			        
			        String u = jsonMap.get(key).toString();
			        
			        maps.put(key, u);  
			        
			    }
			    
			    JSONObject json = null;
			    
			    JSONObject jso = null;
			    
			   if (maps!=null && !maps.isEmpty()){
				   
				   if (maps.get("content")!=null){
					   
					  jso  = JSONObject.fromObject(maps.get("content").toString());
					     
					  if (jso!=null && jso.get("address_detail")!=null){
					    	 
						  json = JSONObject.fromObject(jso.get("address_detail"));
							   
						   map.put("message", "定位成功!");	 
								  
						   map.put("messcode", "002");
						   
						   map.put("city", json.getString("city"));
						   
						   //map.put("addressDetail", jso.get("address_detail"));

					     }else {
					    	 
					    	 map.put("message", "定位失败，请稍后!");
					    	 
					    	 map.put("messcode", "002");	   
					    	 
					     }
				   }
			     
			    }else {
			    	
			    map.put("message", "定位失败，请稍后!");
					  
			    map.put("messcode", "002");	   
					   
			    }
			}
			
		} catch (Exception e) {
			
			 e.printStackTrace();
			
			  map.put("message", "系统异常!");
			  
			  map.put("messcode", "003");
			  
		}
		
		return map;
		
		
	}

}
