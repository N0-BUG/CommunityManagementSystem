package Servlet;

import Members.Message;
import Service.ResidentMessageControlService;
import Service.conduct.ResidentMessageControlServiceConduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResidentMessageControl")
public class ResidentMessageControlServlet extends HttpServlet {
    private ResidentMessageControlService residentmessageControlService = new ResidentMessageControlServiceConduct();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取查询方式
        String method = req.getParameter("method");
        //实现method各值功能
        switch (method) {
            case "list":
                req.setAttribute("list", this.residentmessageControlService.list());
                req.getRequestDispatcher("/residentMessageControl.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.residentmessageControlService.search(key, value));
                req.getRequestDispatcher("/residentMessageControl.jsp").forward(req, resp);
                break;
            case "add":
                String info = req.getParameter("message_info");
                String publisher = req.getParameter("message_publisher");
                String date = req.getParameter("message_date");
                this.residentmessageControlService.addMessage(new Message(info, publisher, date));
                resp.sendRedirect("/ResidentMessageControl?method=list");
                break;
        }
    }
}