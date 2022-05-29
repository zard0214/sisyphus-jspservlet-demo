package controller;


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
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        System.out.println(req.getParameterNames());
        user.setName(req.getParameter("name"));
        user.setType(4);
        user.setPwd(req.getParameter("pwd"));
        user.setStudentId(req.getParameter("student_id"));
        DAOOperator.INSTANCE.getUserDAO().save(user);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<p>注册成功</p><br>");
    }
}
