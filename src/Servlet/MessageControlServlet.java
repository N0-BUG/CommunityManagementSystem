package Servlet;

import Members.Message;
import Service.MessageControlService;
import Service.conduct.MessageControlServiceConduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MessageControl")
public class MessageControlServlet extends HttpServlet {
    private MessageControlService messageControlService = new MessageControlServiceConduct();

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
                req.setAttribute("list", this.messageControlService.list());
                req.getRequestDispatcher("/messageControl.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.messageControlService.search(key, value));
                req.getRequestDispatcher("/messageControl.jsp").forward(req, resp);
                break;
            case "add":
                String info = req.getParameter("message_info");
                String publisher = req.getParameter("message_publisher");
                String date = req.getParameter("message_date");
                this.messageControlService.addMessage(new Message(info, publisher, date));
                resp.sendRedirect("/MessageControl?method=list");
                break;
            case "update":
                Integer id = Integer.parseInt(req.getParameter("message_index"));
                info = req.getParameter("message_info");
                publisher = req.getParameter("message_publisher");
                date = req.getParameter("message_date");
                this.messageControlService.updateMessage(new Message(id, info, publisher, date));
                resp.sendRedirect("/MessageControl?method=list");
                break;
            case "del":
                id = Integer.parseInt(req.getParameter("message_index"));
                this.messageControlService.del(id);
                resp.sendRedirect("/MessageControl?method=list");
                break;
        }
    }
}