package com.shb.web.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

public class BaiduMapUtil {
	
	/**
	 * IP 获取位置
	 */
	
	@SuppressWarnings("unchecked")
	public  static String getBaiduMapsApiIp(String ip){
		
		String cityName = "北京市"; // 默认北京市
		
		try {
			
			HttpRequester requests = new HttpRequester();

			requests.setDefaultContentEncoding("utf-8");
			
	           if (ip!=null && ip!=""){
	        	   
	        	  if(!isIP(ip)){
	        		  
	        		  return cityName;
	        	  } 
				
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
						   
						   System.out.println(jso.get("address"));
						   
						   cityName = json.getString("city");
							     
						   //map.put("addressDetail", jso.get("address_detail"));

					     }
				   }
			     
			}
			
	           }
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			return cityName;
			
		}
		
		return cityName;
	}

	/**
	 * :用正则表达式判断是否为IP
	 * @author wanghao
	 *
	 */
	
	        public static boolean isIP(String addr)   {   
	      
	            if(addr.length() < 7 || addr.length() > 15 || "".equals(addr)) {  
	            
	                return false;  
	            }  
	            /** 
	             * 判断IP格式和范围 
	             */  
	            String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";  
	              
	            Pattern pat = Pattern.compile(rexp);    
	              
	            Matcher mat = pat.matcher(addr);    
	              
	            boolean ipAddress = mat.find();  
	  
	            return ipAddress;  
	        }  
	        
	        
	    }  


