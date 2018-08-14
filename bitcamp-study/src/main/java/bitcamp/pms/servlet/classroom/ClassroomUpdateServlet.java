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
@WebServlet("/classroom/update")
public class ClassroomUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            Classroom classroom = new Classroom();
            classroom.setTitl(request.getParameter("titl"));
            classroom.setSdt(request.getParameter("sdt"));
            classroom.setEdt(request.getParameter("edt"));
            classroom.setRoom(request.getParameter("room"));
            classroom.setCrno(Integer.parseInt(request.getParameter("crno")));
            
            System.out.println(request.getParameter("titl"));
            System.out.println(request.getParameter("sdt"));
            System.out.println(request.getParameter("edt"));
            System.out.println(request.getParameter("room"));
            System.out.println(request.getParameter("crno"));
            
            
            ClassroomDao classroomDao = 
                    (ClassroomDao) getServletContext().getAttribute("classroomDao");
                 
            
            System.out.println(classroomDao);
            
            
            if (classroomDao.update(classroom) == 0) {
                RequestDispatcher rd = 
                        request.getRequestDispatcher("/classroom/updatefail.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("list");
            }
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
    
}









