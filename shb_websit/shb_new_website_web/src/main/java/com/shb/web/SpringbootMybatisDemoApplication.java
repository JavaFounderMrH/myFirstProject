package com.shb.web;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@MapperScan("com.shb.web.dao")
public class SpringbootMybatisDemoApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootMybatisDemoApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
	}
	
	@Bean    
	 public ErrorPageFilter errorPageFilter() {   
	      return new ErrorPageFilter();   
	 }    
	@Bean
	public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {        
	      FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();           
	      filterRegistrationBean.setFilter(filter);      
	      filterRegistrationBean.setEnabled(false);      
	      return filterRegistrationBean;  
	}
}    

