import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 浏览器到servlet -  service - dao - 操作数据库  双向
 */

public class LoginServlet extends HttpServlet {

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println("登陆的service");
////        super.service(req,res); //一般不调用 避免出现405方法找不到（调用父类的方法必须写doGet()/doPost()）
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //2.处理请求乱码
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求的信息
        String username = req.getParameter("username");
        //转编码格式：第一种方式
//        username = new String(username.getBytes("iso8859-1"),"utf-8");

        String pwd = req.getParameter("password");
        System.out.println("页面获取的： " + username + pwd);
        //处理请求信息
            //获取业务层对象
        LoginService loginService = new LoginServiceImpl();

        User user = loginService.checkLoginService(username, pwd);
        System.out.println(user);
        if (user!= null){
            //请求转发
            //使用request对象实现不同servlet的数据流传
//            req.setAttribute("error","用户名或者密码错误");
//            req.getRequestDispatcher("LoginDemo.jsp").forward(req,resp);
            //请求重定向
            resp.sendRedirect("RequestRedirectServlet.jsp");
        }else {
            //使用request对象实现不同servlet的数据流传
            req.setAttribute("error","用户名或者密码错误");
//            resp.getWriter().write("login fail");
            req.getRequestDispatcher("LoginDemo.jsp").forward(req,resp);
        }
    }

}
