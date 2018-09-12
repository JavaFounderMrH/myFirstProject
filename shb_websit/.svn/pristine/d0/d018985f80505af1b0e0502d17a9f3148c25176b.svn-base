package com.shb.web.web.util;

import java.io.*;  
import org.apache.commons.httpclient.*;  
import org.apache.commons.httpclient.methods.*;  
import org.apache.commons.httpclient.params.HttpMethodParams;  
  
/** 
 * 静态页面引擎技术（突乱了乱码问题UTF-8） 
 * @author 
 * 
 */  
public class HtmlGenerator{
    HttpClient httpClient = null; //HttpClient实例  
    GetMethod getMethod =null; //GetMethod实例  
    BufferedWriter fw = null;  
    String page = null;  
    String webappname = null;  
    BufferedReader br = null;  
    InputStream in = null;  
    StringBuffer sb = null;  
    String line = null;   
    //构造方法  
    public HtmlGenerator(String webappname){  
        this.webappname = webappname;  
          
    }  
      
    /** 根据模版及参数产生静态页面 */  
    public boolean createHtmlPage(String url,String htmlFileName){  
        boolean status = false;   
        int statusCode = 0;               
        try{  
            //创建一个HttpClient实例充当模拟浏览器  
            httpClient = new HttpClient();  
            //设置httpclient读取内容时使用的字符集  
            httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");           
            //创建GET方法的实例  
            getMethod = new GetMethod(url);  
            //使用系统提供的默认的恢复策略，在发生异常时候将自动重试3次  
            getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());  
            //设置Get方法提交参数时使用的字符集,以支持中文参数的正常传递  
            getMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");  
            //执行Get方法并取得返回状态码，200表示正常，其它代码为异常  
            statusCode = httpClient.executeMethod(getMethod);             
            if (statusCode!=200) {  
                System.out.println("静态页面引擎在解析"+url+"产生静态页面"+htmlFileName+"时出错!");  
            }else{  
                //读取解析结果  
                sb = new StringBuffer();  
                in = getMethod.getResponseBodyAsStream();  
                //br = new BufferedReader(new InputStreamReader(in));//此方法默认会乱码，经过长时期的摸索，下面的方法才可以  
                br = new BufferedReader(new InputStreamReader(in,"UTF-8"));  
                while((line=br.readLine())!=null){  
                    sb.append(line+"\n");  
                }  
                if(br!=null)br.close();  
                page = sb.toString();  
                //将页面中的相对路径替换成绝对路径，以确保页面资源正常访问  
                page = formatPage(page);  
                System.out.println(page);
                System.out.println("11111111111111111"+htmlFileName);
                //将解析结果写入指定的静态HTML文件中，实现静态HTML生成  
                writeHtml(htmlFileName,page);  
                status = true;  
            }             
        }catch(Exception ex){  
        	System.out.println("静态页面引擎在解析"+url+"产生静态页面"+htmlFileName+"时出错:"+ex.getMessage());           
        }finally{  
            //释放http连接  
            getMethod.releaseConnection();  
        }  
        return status;  
    }  
      
    //将解析结果写入指定的静态HTML文件中  
    private synchronized void writeHtml(String htmlFileName,String content) throws Exception{  
        fw = new BufferedWriter(new FileWriter(htmlFileName));  
        OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(htmlFileName),"UTF-8");  
        fw.write(page);   
        if(fw!=null)fw.close();       
    }  
      
    //将页面中的相对路径替换成绝对路径，以确保页面资源正常访问  
    private String formatPage(String page){       
        page = page.replaceAll("\\.\\./\\.\\./\\.\\./", webappname+"/");  
        page = page.replaceAll("\\.\\./\\.\\./", webappname+"/");  
        page = page.replaceAll("\\.\\./", webappname+"/");  
        
        System.out.println("========================================="+page);
        return page;  
    }  
      
    //测试方法  
    public static void main(String[] args){  
        HtmlGenerator h = new HtmlGenerator("shb_new_website_web");  
      h.createHtmlPage("http://192.168.3.128:8099/test/5","E:/shb_web20180613/shb_new_website/shb_new_website_web/src/main/webapp/sunholiday/html/"+5+".html");
      // h.createHtmlPage("http://192.168.3.128:9099/shb_new_website_web/test/2","/tools/apache-tomcat-8.5.31/webapps/html/"+2+".html");

       //h.createHtmlPage("http://www.shanhaibian.com/shb_front_web/room/details?sriId=637","/usr/java/apache-tomcat-7.0.59/webapps/shb_front_web/room/detail/");
        System.out.println("活动静态页面已更新");  
      
    }
    
    public static boolean createStaticHtml(String url,String parameter,String path){
    	
    	HtmlGenerator h = new HtmlGenerator("shb_new_website_web");
    	
    	boolean res = h.createHtmlPage(url+parameter,path+parameter+".html");
    	
    	return res;
    	
    }
    
    public static boolean createStaticHtmlRoomList(String url,String parameter,String path){
    	
    	HtmlGenerator h = new HtmlGenerator("shb_front_web");
    	
    	String name = parameter;
    	
    	if(parameter.equals("010")){
    		
    		name = "beijing";
    		
    	}
    	
    	if(parameter.equals("0571")){
    		
    		name = "hangzhou";
    		
    	}
    	
    	if(parameter.equals("0532")){
    		
    		name = "qingdao";
    		
    	}
    	
    	if(parameter.equals("0411")){
    		
    		name = "dalian";
    		
    	}
    	
    	if(parameter.equals("0888")){
    		
    		name = "lijiang";
    		
    	}
    	
    	if(parameter.equals("0451")){
    		
    		name = "haerbin";
    		
    	}
    	
    	if(parameter.equals("0535")){
    		
    		name = "yantai";
    		
    	}
    	
    	if(parameter.equals("0631")){
    		
    		name = "weihai";
    		
    	}
    	
    	if(parameter.equals("0837")){
    		
    		name = "jiuzhaigou";
    		
    	}
    	
    	if(parameter.equals("0512")){
    		
    		name = "suzhou";
    		
    	}
    	
    	if(parameter.equals("0691")){
    		
    		name = "xishuangbanna";
    		
    	}
    	
    	if(parameter.equals("0592")){
    		
    		name = "xiamen";
    		
    	}
    	
    	if(parameter.equals("029")){
    		
    		name = "xian";
    		
    	}
    	
    	if(parameter.equals("0872")){
    		
    		name = "dali";
    		
    	}
    	
    	if(parameter.equals("0439")){
    		
    		name = "changbaishan";
    		
    	}
    	
    	if(parameter.equals("0898")){
    		
    		name = "sanya";
    		
    	}
    	
    	if(parameter.equals("0573")){
    		
    		name = "jiaxing";
    		
    	}
	
    	boolean res = h.createHtmlPage(url+parameter,path+name+".html");
    	
    	return res;
    	
    }
  
}  
