package download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * <ol>
 *     <li>获取文件名称</li>
 *     <li>使用字节流加载文件进内存</li>
 *     <li>指定response的响应头：content-disposition:attachment;filename=xxx</li>
 *     <li>将数据写出到response输出流</li>
 * </ol>
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1 找到文件服务器路径
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/uploaded/" + filename);
        //2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3.设置response的响应头
        //3.1设置响应头类型：conetent-type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", mimeType);
        //3.2设置响应头打开方式

        //解决中文文件名问题
        //1.获取user-agent请求头
        String agent = req.getHeader("user-agent");
        //2.使用工具类编码文件名
        filename = DownLoadUtils.getFileName(agent, filename);

        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        //4.将输入流的数据写出到输出流中:content-disposition

        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        fis.close();
    }
}
