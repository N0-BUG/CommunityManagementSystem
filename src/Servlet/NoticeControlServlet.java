package Servlet;

import Members.Notice;
import Service.NoticeControlService;
import Service.conduct.NoticeControlServiceConduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NoticeControl")
public class NoticeControlServlet extends HttpServlet {
    private NoticeControlService noticeControlService = new NoticeControlServiceConduct();

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
                req.setAttribute("list", this.noticeControlService.list());
                req.getRequestDispatcher("/noticeControl.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.noticeControlService.search(key, value));
                req.getRequestDispatcher("/noticeControl.jsp").forward(req, resp);
                break;
            case "add":
                String info = req.getParameter("notice_info");
                String publisher = req.getParameter("notice_publisher");
                String date = req.getParameter("notice_date");
                this.noticeControlService.addNotice(new Notice(info, publisher, date));
                resp.sendRedirect("/NoticeControl?method=list");
                break;
            case "update":
                Integer id = Integer.parseInt(req.getParameter("notice_index"));
                info = req.getParameter("notice_info");
                publisher = req.getParameter("notice_publisher");
                date = req.getParameter("notice_date");
                this.noticeControlService.updateNotice(new Notice(id, info, publisher, date));
                resp.sendRedirect("/NoticeControl?method=list");
                break;
            case "del":
                id = Integer.parseInt(req.getParameter("notice_index"));
                this.noticeControlService.del(id);
                resp.sendRedirect("/NoticeControl?method=list");
                break;
        }
    }
}