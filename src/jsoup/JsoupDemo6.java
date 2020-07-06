package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) {
        File file = new File("web/xml/users.xml");
        try {
            //1.获取Document对象
            Document document = Jsoup.parse(file, "utf-8");
            Elements elements = document.getElementsByTag("users");
            //2.根据Document对象创建JXDocument对象
            JXDocument jxDocument=new JXDocument(elements);

            //3.解饿XPath语法查询
            //3.1查询所有的user标签
            List<JXNode> jxNodes = jxDocument.selN("//user");
            for (JXNode jxNode : jxNodes) {
                System.out.println(jxNode);
            }
            System.out.println("--------------");
            //3.2查询所有的user标签下的name标签
            List<JXNode> jxNodes2 = jxDocument.selN("//user/name");
            for (JXNode jxNode : jxNodes2) {
                System.out.println(jxNode);
            }
            System.out.println("--------------");

            //3.3查询user标签下带有lalal属性的name标签
            List<JXNode> jxNodes3 = jxDocument.selN("//user/name[@lalala]");
            for (JXNode jxNode : jxNodes3) {
                System.out.println(jxNode);
            }
            System.out.println("--------------");

            //3.4查询id=“2”的user标签下的name标签
            List<JXNode> jxNodes4 = jxDocument.selN("//user[@id='2']/name");
            for (JXNode jxNode : jxNodes4) {
                System.out.println(jxNode);
            }
            System.out.println("--------------");
        } catch (IOException | XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
