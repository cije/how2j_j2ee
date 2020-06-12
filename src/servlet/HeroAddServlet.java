package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Hero h = new Hero();
        h.setName(req.getParameter("name"));
        h.setHp(Float.parseFloat(req.getParameter("hp")));
        h.setDamage(Integer.parseInt(req.getParameter("damage")));
        new HeroDAO().add(h);

        resp.sendRedirect("/j2ee/listHero");
    }
}
