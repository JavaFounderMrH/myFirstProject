package com.shb.web.web.util;

import java.io.*;
import java.net.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;

public class Client {
	
	public static String mdsmssend(String phoneno,String contect) throws UnsupportedEncodingException {
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new NameValuePair("sn", "SDK-GGH-010-00165"));
		params.add(new NameValuePair("pwd","6801DB3A0B3E06DCA3C19AF56F64B427"));
		params.add(new NameValuePair("mobile", phoneno));
		params.add(new NameValuePair("content", URLEncoder.encode(contect,"utf-8")));
		params.add(new NameValuePair("ext", ""));
		params.add(new NameValuePair("stime", ""));
		params.add(new NameValuePair("rrid", ""));
		params.add(new NameValuePair("msgfmt", ""));
		String result = Client.request(url, params.toArray(new NameValuePair[params.size()]));
		return result;
	}
	
	/**
	 * 
	 * 鑱氫俊鐭俊鍙戦��
	 * 
	 * @param phone
	 * @param content
	 * @return
	 */
	public static String juxinMsSend(String phone,String content){
		
		String url = "http://api.app2e.com/smsBigSend.api.php";
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new NameValuePair("username", "shbbj"));
		
		params.add(new NameValuePair("pwd","97c26a62663a97a8e156698a8f87e18b"));//DN3zXztw
		
		params.add(new NameValuePair("p", phone));
		
		try {
			
			params.add(new NameValuePair("msg", URLEncoder.encode(content,"utf-8")));
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		params.add(new NameValuePair("extnum", ""));
		
		params.add(new NameValuePair("isUrlEncode", "yes"));
		
		params.add(new NameValuePair("charSetStr", "utf"));
		
		String result = Client.request(url, params.toArray(new NameValuePair[params.size()]));
		
		return result;
		
	}
	
	public static String request(String url, NameValuePair[] params) {

		String result = null;

		HttpClient client = new HttpClient();

		PostMethod postMethod = new PostMethod(url);

		postMethod.setRequestBody(params);

		int statusCode = 0;
		try {
			statusCode = client.executeMethod(postMethod);
		} catch (HttpException e) {
		} catch (IOException e) {
		}

		try {
			if (statusCode == HttpStatus.SC_OK) {
				result = postMethod.getResponseBodyAsString();
				return result;
			} else {
			}
		} catch (IOException e) {
		}
		postMethod.releaseConnection();
		return result;

	}
	
}
