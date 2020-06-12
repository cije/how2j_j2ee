import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
	System.out.println("init of HelloServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// 获取头信息
	Enumeration<String> headerNames = request.getHeaderNames();
	while (headerNames.hasMoreElements()) {
	    String header = headerNames.nextElement();
	    String value = request.getHeader(header);
	    System.out.printf("%s\t%s%n", header, value);
	}

	try {
	    // 仅仅是发送的浏览器的内容是UTF-8编码的，至于浏览器是用哪种编码方式显示不管。
	    // 所以当浏览器的显示编码方式不是UTF-8的时候，就会看到乱码，需要手动再进行一次设置。
//	    response.setCharacterEncoding("UTF-8");
	    // 不仅发送到浏览器的内容会使用UTF-8编码，而且还通知浏览器使用UTF-8编码方式进行显示。所以总能正常显示中文
	    response.setContentType("text/html;charset=UTF-8");

	    // 不使用缓存
	    response.setDateHeader("Expires", 0);
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("pragma", "no-cache");

	    response.getWriter().println("<h1>Hello Servlet!</h1>");
	    response.getWriter().println("<p>第一次使用Servlet</p>");
	    response.getWriter().println(new Date().toString());
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }
}
