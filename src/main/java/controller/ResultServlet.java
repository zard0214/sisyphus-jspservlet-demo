package controller;

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

/**
 * @author zard
 * @date Created in 27/05/2022 02:09
 */
@WebServlet("/result.do")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        User user = DAOOperator.INSTANCE.getUserDAO().getByStudentId(studentId);
        Samples samples = DAOOperator.INSTANCE.getSamplesDAO().getByStudentId(user.getId() + "");
        if(samples == null){
            samples = new Samples("1", "", "", "未采样");
            req.setAttribute("samples", samples);
        }else{
            req.setAttribute("samples", samples);
        }
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
