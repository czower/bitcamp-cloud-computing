package bitcamp.pms.iistener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.dao.ClassroomDao;

@WebListener
public class ContextLoaderListener 
    implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행!");
        
        try {
            String resource = "bitcamp/pms/config/mybatis-config.xml";
            InputStream inputStream =
                    Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            
            ClassroomDao classroomDao = new ClassroomDao(sqlSessionFactory);            
            
            ServletContext sc = sce.getServletContext();
            sc.setAttribute("classroomDao", classroomDao);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}



