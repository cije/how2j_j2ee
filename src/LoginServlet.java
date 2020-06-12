import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author c__e
 */
public class LoginServlet extends HttpServlet {

    // 无论访问了多少次LoginServlet LoginServlet构造方法 只会执行一次，所以Servlet是单实例的
    public LoginServlet() {
	System.out.println("LoginServlet 构造方法 被调用");
    }

    // 无论访问了多少次LoginSerlvet init初始化 只会执行一次
    @Override
    public void init() throws ServletException {
	System.out.println("init(ServletConfig)");
    }

    // 接下来就是执行service()方法，然后通过浏览器传递过来的信息进行判断，是调用doGet()还是doPost()方法
    // 在service()中就会编写我们的业务代码，在本例中就是判断用户输入的账号和密码是否正确
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
//	req.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String password = request.getParameter("password");

//	System.out.println("name: " + name);
//	System.out.println("password: " + password);

	String correctName = "admin", correctPassword = "123";
	String html = null;

//	if (correctName.equals(name) && correctPassword.equals(password)) {
//	    html = "<div style='color:green'>登陆成功</div>";
//	} else {
//	    html = "<div style='color:red'>登陆失败</div>";
//	}
//
//	// 返回中文的响应
//	resp.setContentType("text/html;charset=UTF-8");
//	PrintWriter pw = resp.getWriter();
//	pw.println(html);

	if (correctName.equals(name) && correctPassword.equals(password)) {
	    // 服务端跳转 可以看到浏览器的地址依然是/login 路径，并不会变成success.html
	    request.getRequestDispatcher("success.html").forward(request, response);
	} else {
	    // 客户端跳转 可以观察到，浏览器地址发生了变化
	    // 302 表示临时跳转
	    response.sendRedirect("fail.html");
	    // 301 永久跳转
//	    response.setStatus(301);
//	    response.setHeader("Location", "fail.html");
	}
    }
    // @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String password = req.getParameter("password");
//
//        String html = null;
//
//        if ("admin".equals(name) && "123".equals(password)) {
//            html = "<div style='color:green'>success<div/>";
//        } else {
//            html = "<div style='color:red'>fail<div/>";
//        }
//        PrintWriter pw = resp.getWriter();
//        pw.println(html);
//    }

    @Override
    public void destroy() {
	System.out.println("destory()");
    }
}
