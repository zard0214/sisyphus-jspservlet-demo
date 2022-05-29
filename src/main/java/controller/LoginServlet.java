package controller;

import dao.DAOOperator;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zard
 * @date Created in 27/05/2022 02:09
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            HttpSession session = req.getSession();
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            User user = DAOOperator.INSTANCE.getUserDAO().getByName(name);
            if(user != null && password.equals(user.getPwd())){
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/manager.do?userType=" + user.getType());
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<p>账号密码错误</p><br>");
            e.printStackTrace();
        }
    }
}
