package Servlet;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private boolean isSafeRequest(HttpServletRequest req) {
        String servletPath = req.getServletPath();
        if (("/index.jsp".equals(servletPath)) || ("/login".equals(servletPath)) || ("/register.jsp".equals(servletPath)) || ("/contact.jsp".equals(servletPath)) || ("/SystemControl?method=register".equals(servletPath)) || ("/SystemControl".equals(servletPath))) {
            return true;
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取HttpServlet对象
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (isSafeRequest(req)) {
            chain.doFilter(req, resp);
        } else {
            //获取Session对象
            HttpSession session = req.getSession();
            String user_name = (String) session.getAttribute("user_name");
            //有Session信息，已登录—>可以访问
            if (null != user_name) {
                chain.doFilter(req, resp);
            } else {
                boolean isLogin = false;
                //没有登录
                Cookie[] cookies = req.getCookies();
                //循环遍历Cookie数组获取cookie对象
                for (Cookie cookie : cookies) {
                    //判断当前的cookie对象是否为登录信息的cookie对象
                    isLogin = "user_name".equals(cookie.getName());

                    if (isLogin) {
                        session.setAttribute("user_name", cookie.getValue());
                        chain.doFilter(req, resp);
                        break;
                    }
                }
                //没有登录过无法访问,自动跳转到登录页面
                if (!isLogin) {
                    resp.sendRedirect("/index.jsp");
                }
            }
        }
    }
}


