package Servlet;

import Dto.UserDto;
import Service.LoginService;
import Service.conduct.LoginServiceConduct;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceConduct();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求参数
        req.setCharacterEncoding("utf-8");
        String user_name = req.getParameter("user_name");
        String user_password = req.getParameter("user_password");
        String user_ident = req.getParameter("user_ident");
        UserDto userDto = this.loginService.login(user_name, user_password, user_ident);
        //创建session对象用于判断登录状态给过滤器识别
        HttpSession session = null;
        //对比账号密码
        switch (userDto.getMessage()) {
            case 0:
                resp.sendRedirect("/?error=user_nameError");
                break;
            case -1:
                resp.sendRedirect("/?error=user_passwordError");
                break;
            case -2:
                resp.sendRedirect("/?error=user_identError");
                break;
            case 1:
                //给过滤器识别
                session = req.getSession(true);
                session.setAttribute("user_name", user_name);
                resp.sendRedirect("/resident.jsp");
                break;
            case 2:
                //给过滤器识别
                session = req.getSession(true);
                session.setAttribute("user_name", user_name);
                resp.sendRedirect("/manager.jsp");
                break;
        }

    }
}