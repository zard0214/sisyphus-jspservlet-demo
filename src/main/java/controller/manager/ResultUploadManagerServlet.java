package controller.manager;

import dao.DAOOperator;
import jms.QSender;
import model.Samples;

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
@WebServlet("/resultUploadManager.do")
public class ResultUploadManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Samples> type = new ArrayList();
        Samples type1 = new Samples();
        Samples type2 = new Samples();
        type1.setResult(1);
        type1.setResultStr("阴性");
        type.add(type1);
        type2.setResult(2);
        type2.setResultStr("阳性");
        type.add(type2);
        req.setAttribute("typeList", type);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resultUpload.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tube_number = req.getParameter("tube_number");
        String[] tubes = tube_number.split(",");
        Integer type = Integer.valueOf(req.getParameter("type"));
        for (int i = 0; i < tubes.length; i++) {
            Samples samples = new Samples();
            samples.setTubeNumber(tubes[i]);
            samples.setResult(type);
            DAOOperator.INSTANCE.getSamplesDAO().update(samples);
            //send message
            try {
                new QSender().send(samples);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        resp.sendRedirect(req.getContextPath() + "/resultUploadManager.do");
    }
}
