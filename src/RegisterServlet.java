import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
	// TODO 自动生成的方法存根
	super.init();
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	// TODO 自动生成的方法存根
	super.service(arg0, arg1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口（如果有）：" + req.getRequestURL());
	System.out.println("浏览器发出请求的资源名部分 去掉了协议和主机名：" + req.getRequestURI());
	System.out.println("请求行中的参数部分：" + req.getQueryString());
	System.out.println("浏览器所处于的客户机的IP地址：" + req.getRemoteAddr());
	System.out.println("浏览器所处于的客户机的主机名：" + req.getRemoteHost());
	System.out.println("浏览器所处于的客户机使用的网络端口：" + req.getRemotePort());
	System.out.println("服务器的IP地址：" + req.getLocalAddr());
	System.out.println("服务器的主机名：" + req.getLocalName());
	System.out.println("得到客户机的请求方式：" + req.getMethod());

	// 获取参数
	System.out.println("获取单值参数name：" + req.getParameter("name"));

	String[] hobits = req.getParameterValues("hobits");
	System.out.println("获取具有多值的参数hobits：" + Arrays.asList(hobits));

	System.out.println("通过 getParameterMap 遍历所有的参数：");
	Map<String, String[]> parameters = req.getParameterMap();

	Set<String> paramNames = parameters.keySet();
	for (String param : paramNames) {
	    String[] value = parameters.get(param);
	    System.out.println(param + "：" + Arrays.asList(value));
	}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
    }
}
