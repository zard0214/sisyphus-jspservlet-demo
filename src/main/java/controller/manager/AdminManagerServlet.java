package controller.manager;


import dao.DAOOperator;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zard
 * @date Created in 27/05/2022 02:09
 */
@WebServlet("/adminManager.do")
public class AdminManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("list")) {
            List<User> userList = DAOOperator.INSTANCE.getUserDAO().getAll();
            req.setAttribute("userList", userList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/adminManager.jsp");
            dispatcher.forward(req, resp);
        }else if (action.equalsIgnoreCase("insert")) {
            List<User> type = new ArrayList();
            User type1 = new User();
            User type2 = new User();
            User type3 = new User();
            type1.setTypeName("核酸采集大白用户");
            type1.setType(2);
            type.add(type1);
            type2.setTypeName("检测结果上传用户");
            type2.setType(3);
            type.add(type2);
            type3.setTypeName("被检测者学生用户");
            type3.setType(4);
            type.add(type3);
            req.setAttribute("typeList", type);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/insertUser.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        System.out.println(req.getParameterNames());
        user.setName(req.getParameter("name"));
        user.setType(Integer.valueOf(req.getParameter("type")));
        user.setStudentId(req.getParameter("student_id"));
        DAOOperator.INSTANCE.getUserDAO().save(user);
        resp.sendRedirect(req.getContextPath() + "/adminManager.do?action=list");
    }
}
