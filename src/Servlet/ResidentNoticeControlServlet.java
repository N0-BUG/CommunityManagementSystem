package Servlet;

import Service.NoticeControlService;
import Service.ResidentNoticeControlService;
import Service.conduct.NoticeControlServiceConduct;
import Service.conduct.ResidentNoticeControlServiceConduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResidentNoticeControl")
public class ResidentNoticeControlServlet extends HttpServlet {
    private ResidentNoticeControlService residentNoticeControlService = new ResidentNoticeControlServiceConduct();

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
                req.setAttribute("list", this.residentNoticeControlService.list());
                req.getRequestDispatcher("/residentNoticeControl.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.residentNoticeControlService.search(key, value));
                req.getRequestDispatcher("/residentNoticeControl.jsp").forward(req, resp);
                break;

        }
    }
}