import bean.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
public class SubmitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data =req.getParameter("data");

        System.out.println("服务端接收到的数据是：" +data);

        JSONObject json=JSONObject.parseObject(data);

        System.out.println("转换为JSON对象之后是："+ json);

        Hero hero = (Hero)JSONObject.toJavaObject(json,Hero.class);
        System.out.println("转换为Hero对象之后是："+hero);
    }
}
