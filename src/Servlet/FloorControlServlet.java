package Servlet;

import Members.Floor;
import Service.FloorControlService;
import Service.conduct.FloorControlServiceConduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FloorControl")
public class FloorControlServlet extends HttpServlet {
    private FloorControlService floorControlService = new FloorControlServiceConduct();

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
                req.setAttribute("list", this.floorControlService.list());
                req.getRequestDispatcher("/floorControl.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.floorControlService.search(key, value));
                req.getRequestDispatcher("/floorControl.jsp").forward(req, resp);
                break;
            case "add":
                String no = req.getParameter("floor_no");
                String manager = req.getParameter("floor_manager");
                String host = req.getParameter("floor_host");
                String houseNumber = req.getParameter("floor_houseNumber");
                int sum = Integer.parseInt(req.getParameter("floor_sum"));
                this.floorControlService.addFloor(new Floor(no, manager, host, sum, houseNumber));
                resp.sendRedirect("/FloorControl?method=list");
                break;
            case "update":
                Integer id = Integer.parseInt(req.getParameter("floor_index"));
                no = req.getParameter("floor_no");
                manager = req.getParameter("floor_manager");
                host = req.getParameter("floor_host");
                houseNumber = req.getParameter("floor_houseNumber");
                sum = Integer.parseInt(req.getParameter("floor_sum"));
                this.floorControlService.updateFloor(new Floor(id, no, manager, host, sum, houseNumber));
                resp.sendRedirect("/FloorControl?method=list");
                break;
            case "del":
                id = Integer.parseInt(req.getParameter("floor_index"));
                this.floorControlService.del(id);
                resp.sendRedirect("/FloorControl?method=list");
                break;
        }
    }
}