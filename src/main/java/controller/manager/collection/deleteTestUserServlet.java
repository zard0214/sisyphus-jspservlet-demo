package controller.manager.collection;

import dao.DAOOperator;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zard
 * @date Created in 27/05/2022 02:09
 */
@WebServlet("/deleteTestUser.do")
public class deleteTestUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteTestUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User query = new User();
        System.out.println(req.getParameterNames());
        query.setName(req.getParameter("name"));
        query.setStudentId(req.getParameter("student_id"));
        User user = DAOOperator.INSTANCE.getUserDAO().getByNameAndStudentId(query.getName(), query.getStudentId());
        if(user != null){
            resp.sendRedirect(req.getContextPath() + "/collectionManager.do?action=list&userId=" + user.getId());
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<p>学生不存在</p><br>");
        }
    }
}
