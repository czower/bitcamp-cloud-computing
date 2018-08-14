package bitcamp.pms.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.contoller.BoardAddController;
import bitcamp.pms.contoller.BoardDeleteController;
import bitcamp.pms.contoller.BoardListController;
import bitcamp.pms.contoller.BoardUpdateController;
import bitcamp.pms.contoller.BoardViewController;
import bitcamp.pms.dao.BoardDao;

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
            
            BoardDao boardDao = new BoardDao(sqlSessionFactory); 
            
            ServletContext sc = sce.getServletContext();
            sc.setAttribute("/board/list", new BoardListController(boardDao));
            sc.setAttribute("/board/view", new BoardViewController(boardDao));
            sc.setAttribute("/board/update", new BoardUpdateController(boardDao));
            sc.setAttribute("/board/delete", new BoardDeleteController(boardDao));
            sc.setAttribute("/board/add", new BoardAddController(boardDao));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



