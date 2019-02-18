package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet初始化完成");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.getWriter().write("servlet生命周期");
        System.out.println("servlet life cycle");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet被销毁");
    }
}
