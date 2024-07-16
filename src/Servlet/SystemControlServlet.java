package Servlet;

import Members.Resident;
import Members.User;
import Service.ManagerControlService;
import Service.conduct.ManagerControlServiceConduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SystemControl")
public class SystemControlServlet extends HttpServlet {
    private ManagerControlService managerControlService = new ManagerControlServiceConduct();

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
            case "register":
                String user_name = req.getParameter("user_name");
                String password = req.getParameter("user_password");
                String ident = req.getParameter("user_ident");
                this.managerControlService.register(new User(user_name, password, ident));
                resp.sendRedirect("/index.jsp");
                break;
            case "resident_list":
                req.setAttribute("list", this.managerControlService.list());
                req.getRequestDispatcher("/residentControl.jsp").forward(req, resp);
                break;
            case "resident_search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.managerControlService.search(key, value));
                req.getRequestDispatcher("/residentControl.jsp").forward(req, resp);
                break;
            case "resident_add":
                String name = req.getParameter("resident_name");
                String phone = req.getParameter("resident_phone");
                String houseNumber = req.getParameter("resident_houseNumber");
                String gender = req.getParameter("resident_gender");
                this.managerControlService.addResident(new Resident(name, phone, houseNumber, gender));
                resp.sendRedirect("/SystemControl?method=resident_list");
                break;
            case "resident_update":
                Integer id = Integer.parseInt(req.getParameter("resident_index"));
                name = req.getParameter("resident_name");
                phone = req.getParameter("resident_phone");
                houseNumber = req.getParameter("resident_houseNumber");
                gender = req.getParameter("resident_gender");
                this.managerControlService.updateResident(new Resident(id, name, phone, houseNumber, gender));
                resp.sendRedirect("/SystemControl?method=resident_list");
                break;
            case "resident_del":
                id = Integer.parseInt(req.getParameter("resident_index"));
                this.managerControlService.del(id);
                resp.sendRedirect("/SystemControl?method=resident_list");
                break;
        }

    }
}
