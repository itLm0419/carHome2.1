package com.carhome.spring.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.carhome.vo.User;

@Component
public class SpringListener implements ApplicationListener,ServletContextAware{
	
	private ServletContext servletContext;
	@Autowired  
	private  HttpServletRequest request;  
	//服务器启动事件
		public void onApplicationEvent(ApplicationEvent arg0) {
			if(arg0 instanceof ContextRefreshedEvent)
			{
				System.out.println("启动服务器中... ...");
				User user = new User();
				//test效果，用户存放session
			}
		}
		public void setServletContext(ServletContext arg0) {
			this.servletContext = arg0;
		}


}	
