package servlet;

import com.sun.deploy.nativesandbox.comm.Request;
import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @description 浏览器到servlet -  service - dao - 操作数据库  双向
 */

public class LoginServlet extends HttpServlet {

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println("登陆的service");
////        super.service(req,res); //一般不调用 避免出现405方法找不到（调用父类的方法必须写doGet()/doPost()）
//    }


    ServletConfig servletConfig;
    String servletName;
    String url;
    String configFile;
    Enumeration<String> enumerationServlet;

    ServletContext servletContext;
    String servletContextName;
    Enumeration<String> enumerationServletContext;

    String info;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        info = this.getServletInfo();
        System.out.println("info：" + info);

        /**
         * 获取请求行
         */
        System.out.println("***************获取请求行*****************");
        System.out.println("request URL: " + req.getRequestURL());
        System.out.println("request URI: " + req.getRequestURI());
        System.out.println("request ContextPath: " + req.getContextPath());
        //get请求提交URI地址之后的参数字符串
        System.out.println("request QueryString: " + req.getQueryString());


        /**
         * 请求头的内容
         */
        System.out.println("***************获取请求头*****************");
        System.out.println("******** headerNames & header ***********");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            //获得headerName
            String headerName = headerNames.nextElement();
            System.out.println("headerNames：" + headerName);
            //获得header
            System.out.println("header: " + req.getHeader(headerName));
        }

        System.out.println("******** headers ***********");
        Enumeration<String> headers = req.getHeaders("accept");
        while (headers.hasMoreElements()) {
            System.out.println("heads：" + headers.nextElement());
        }

        /**
         * 获取请求体
         */
        System.out.println("************获取请求体*****************");
        System.out.println("request Parameter: " + req.getParameter("username"));

        System.out.println("request Parameter: " + req.getParameterValues("fav"));

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println("parameterNames：" + parameterNames.nextElement());
        }

        Map<String, String[]> map = req.getParameterMap();


        /**
         * servletContext
         */
        servletContext = this.getServletContext();

        servletContextName = (String) servletContext.getAttribute("param1");
        System.out.println("param1参数：" + getServletContext().getInitParameterNames());

        System.out.println("servletContext全部参数名字：" + getServletContext().getInitParameterNames());
        //2.遍历迭代器
        enumerationServletContext = servletContext.getInitParameterNames();
        while (enumerationServletContext.hasMoreElements()) {
            //获取每个元素的参数名字
            String paramName = enumerationServletContext.nextElement();
            System.out.println("paramName：" + paramName);
            //根据参数名字获取参数值
            String paramValue = servletContext.getInitParameter(paramName);
            System.out.println("paramValue：" + paramValue);
        }

        /**
         * servletConfig
         */
        servletConfig = this.getServletConfig();

        servletName = servletConfig.getServletName();
        System.out.println("servletName：" + servletName);

        //2.遍历迭代器
        //获得init-param参数的Enumeration
        enumerationServlet = servletConfig.getInitParameterNames();
        while (enumerationServlet.hasMoreElements()) {
            String paramName = enumerationServlet.nextElement();
            System.out.println("paramName：" + paramName);
            String paramValue = servletConfig.getInitParameter(paramName);
            System.out.println("paramValue：" + paramValue);
        }

        //获得单个的init-param
        url = servletConfig.getInitParameter("url");
        System.out.println("配置文件的参数url：" + url);

        configFile = servletConfig.getInitParameter("config");
        System.out.println("configFile：" + configFile);

        System.out.println("request AuthType: " + req.getAuthType());


        //cookie
        Cookie[] cookie = req.getCookies();
        for (int i = 0; i < cookie.length; i++) {
            System.out.println(cookie.toString());
        }


        //2.处理请求乱码
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求的信息
        String username = req.getParameter("username");
        //转编码格式：第一种方式
//        username = new String(username.getBytes("iso8859-1"),"utf-8");

        String password = req.getParameter("password");
        System.out.println("页面获取的：" + username + password);


        //处理请求信息
        //获取业务层对象
        LoginService loginService = new LoginServiceImpl();

        User user = loginService.checkLoginService(username, password);
        System.out.println("用户：" + user);

        if (user != null) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.getRequestDispatcher("RequestRedirectServlet.jsp").forward(req, resp);
//            resp.sendRedirect("RequestRedirectServlet.jsp");
        } else {

            //使用request对象实现不同servlet的数据流传
//            req.setAttribute("error", "用户名或者密码错误");
//            resp.getWriter().write("login fail");

            req.getRequestDispatcher("LoginDemo.jsp").forward(req, resp);
        }
    }
}
