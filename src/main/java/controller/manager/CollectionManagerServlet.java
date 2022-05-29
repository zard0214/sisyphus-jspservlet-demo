package controller.manager;

import dao.DAOOperator;
import model.Samples;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author zard
 * @date Created in 27/05/2022 02:09
 */
@WebServlet("/collectionManager.do")
public class CollectionManagerServlet extends HttpServlet {

    private List<User> userList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("list")) {
            if(req.getParameter("userId") != null){
                String userId = req.getParameter("userId");
                User user = DAOOperator.INSTANCE.getUserDAO().getByID(Integer.parseInt(userId));
                if(!userList.contains(user))
                    userList.add(user);
            }
            req.setAttribute("userList", userList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/collectNA.jsp");
            dispatcher.forward(req, resp);
        }else if (action.equalsIgnoreCase("insert")) {
            resp.sendRedirect(req.getContextPath() + "/insertTestUser.do?studentId=" + req.getParameter("student_id"));
        }else if (action.equalsIgnoreCase("delete")) {
            resp.sendRedirect(req.getContextPath() + "/deleteTestUser.do");
        }else if (action.equalsIgnoreCase("deleteUser")) {
            if(req.getParameter("id") != null){
                Iterator<User> it = userList.iterator();
                while(it.hasNext()){
                    User user = it.next();
                    if(Integer.parseInt(req.getParameter("id")) == user.getId()){
                        it.remove();
                    }
                }
            }
            req.setAttribute("userList", userList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/collectNA.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Samples samples = new Samples();
        samples.setGmtCreated(new Date());
        samples.setResult(0);
        samples.setTubeNumber(req.getParameter("tube_number"));
        String userIds = "";
        for (int i = 0; i < userList.size(); i++) {
            userIds += (userList.get(i).getId() + "/");
        }
        samples.setUserIds(userIds);
        DAOOperator.INSTANCE.getSamplesDAO().save(samples);
        userList.clear();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<p>采集成功</p><br>");
    }
}
