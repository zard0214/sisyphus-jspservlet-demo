package controller;


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
@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer userType = Integer.parseInt(req.getParameter("userType"));
        if(userType == 1){//管理员用户
            resp.sendRedirect(req.getContextPath() + "/adminManager.do?action=list");
        }else if(userType == 2){//核酸采集大白用户
            resp.sendRedirect(req.getContextPath() + "/collectionManager.do?action=list");
        }else if(userType == 3){//检测结果上传用户
            resp.sendRedirect(req.getContextPath() + "/resultUploadManager.do");
        }else if(userType == 4){//被检测者学生用户
            resp.sendRedirect(req.getContextPath() + "/detectedManager.do");
        }
    }
}
