/*package com.shb.web.web.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class UserContreoller {
	
	@RequestMapping(value="/queryUser",method = RequestMethod.GET)
	public Map<String,Object> queryUser(
		 
			Long surId
			) {
		
		Map<String, Object> map=new HashMap<String,Object>();
		
		try {
			
			// 创建动态客户端
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client client = (Client) dcf.createClient("http://192.168.3.128:9088/service/user?wsdl");
			// 需要密码的情况需要加上用户名和密码
			// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
			// PASS_WORD));
			Object[] objects = new Object[0];
			
			try {
				
				

				// invoke("方法名",参数1,参数2,参数3....);
				objects = client.invoke("selectByPrimaryKey",surId);
				
				//objects = client.invoke("queryUser",user);

				

			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
			
			
			  map.put("message", "查询成功!");
			  
			  map.put("messcode", "001");
			  
			  map.put("result", objects[0]);
			  
			  return map;	
						
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			 map.put("message", "系统异常!");
			  
			  map.put("messcode", "003");
			  
			  return map;
		}
		
	}

}
*/