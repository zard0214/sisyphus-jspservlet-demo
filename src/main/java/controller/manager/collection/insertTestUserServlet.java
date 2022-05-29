package controller.manager.collection;


import dao.DAOOperator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import model.User;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import java.net.URL;

/**
 * @author zard
 * @date Created in 27/05/2022 02:09
 */
@WebServlet("/insertTestUser.do")
public class insertTestUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        req.setAttribute("studentId", studentId);
        String name = getUserName(req, resp, studentId);
        req.setAttribute("name", name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/insertTestUser.jsp");
        dispatcher.forward(req, resp);
    }

    private String getUserName(HttpServletRequest req, HttpServletResponse resp, String studentId) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL("http://localhost:9000/HelloWorld"));
            call.setUseSOAPAction(true);
            call.setEncodingStyle(null);
            call.setReturnType(XMLType.XSD_STRING);
            call.setOperationName(new QName("http://example/","sayHelloWorldFrom"));
            call.setSOAPActionURI("http://example/" + "sayHelloWorldFrom");
//            call.addParameter(new QName("http://example/", "from"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);
            String userName = (String) call.invoke(new Object[] {studentId});
            resp.setContentType("text/xml");
            resp.setCharacterEncoding("UTF-8");
            return userName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
