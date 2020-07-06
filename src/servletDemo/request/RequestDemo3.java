package servletDemo.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //演示获取请求头数据:USER-AGENT
        String agent = req.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")){
            System.out.println("谷歌浏览器");
        }else if(agent.contains("Edg")){
            System.out.println("Edge浏览器");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
