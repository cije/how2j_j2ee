package servletDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 路径配置
 */
@WebServlet({"/demo4","/demo4_1","/demo4_2"})
//@WebServlet("/lalala/demo4")
//@WebServlet("/lalala/*")
//@WebServlet("/*")
//@WebServlet("*.do")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4 doGet...");
        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4 doPost...");
    }
}
