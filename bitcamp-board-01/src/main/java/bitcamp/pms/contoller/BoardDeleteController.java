package bitcamp.pms.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.BoardDao;

public class BoardDeleteController{
    
    BoardDao boardDao;

    public BoardDeleteController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
       boardDao.delete(request.getParameter("title"));
       return "redirect:list";
        
    }
    
    
}







