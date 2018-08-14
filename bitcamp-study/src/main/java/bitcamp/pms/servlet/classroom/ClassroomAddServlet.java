package bitcamp.pms.servlet.classroom;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.domain.Classroom;

@SuppressWarnings("serial")
@WebServlet("/classroom/add")
public class ClassroomAddServlet extends HttpServlet {    
   
   
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Classroom classroom = new Classroom();
            classroom.setTitl(request.getParameter("title"));
            classroom.setSdt(request.getParameter("startDateTime"));
            classroom.setEdt(request.getParameter("endDateTime"));
            classroom.setRoom(request.getParameter("room"));
            
            ClassroomDao classroomDao = 
                    (ClassroomDao) getServletContext().getAttribute("classroomDao");
                 
            classroomDao.insert(classroom);
            response.sendRedirect("list");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
