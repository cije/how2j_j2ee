import bean.Hero;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetManyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heros=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Hero hero=new Hero();
            hero.setName("name"+i);
            hero.setHp(500+1);
            heros.add(hero);
        }
        String result= JSONObject.toJSONString(heros);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(result);
    }
}
