import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
	System.out.println("init of UploadSevlet");
	super.init();
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	// TODO 自动生成的方法存根
	super.service(arg0, arg1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String filename = null;
	try {
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    upload.setHeaderEncoding("ISO-8859-1");
	    // 设置上传文件的大小限制为1M
	    factory.setSizeThreshold(1024 * 1024);

	    List items = null;
	    try {
		items = upload.parseRequest(request);
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    Iterator iter = items.iterator();
	    String heroName = null;
	    while (iter.hasNext()) {
		FileItem item = (FileItem) iter.next();
		if (!item.isFormField()) {
		    // 根据时间戳创建头像文件
		    filename = System.currentTimeMillis() + ".jpg";
		    // 通过getRealPath获取上传文件夹
		    String photoFolder = request.getServletContext().getRealPath("uploaded");

		    File f = new File(photoFolder, filename);
		    f.getParentFile().mkdirs();
		    // 通过item.getInputStream()获取浏览器上传的文件的输入流
		    InputStream is = item.getInputStream();

		    // 复制文件
		    FileOutputStream fos = new FileOutputStream(f);
		    byte[] b = new byte[1024 * 1024];
		    int length = 0;
		    while (-1 != (length = is.read(b))) {
			fos.write(b, 0, length);
		    }
		    fos.close();
		} else {
		    System.out.println(item.getFieldName());
		    heroName = item.getString();
		    heroName = new String(heroName.getBytes("ISO-8859-1"), "UTF-8");
		    System.out.println(heroName);
		}
	    }
	    String html = "<img width='200' height='150' src='uploaded/%s' />";
	    response.setContentType("text/html charset=UTF-8");
	    PrintWriter pw = response.getWriter();

	    pw.format(html, filename);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO 自动生成的方法存根
	doPost(req, resp);
    }
}
