package bitcamp.mvc.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener{
  //톰캣서버가 시작할때 알림을 받고 싶을때 ServletContextListener
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("시작");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("끝");
    }
   
}
