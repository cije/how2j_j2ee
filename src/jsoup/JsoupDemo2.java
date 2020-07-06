package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Jsoup对象功能
 */
public class JsoupDemo2 {
    public static void main(String[] args) {
        /*//2.1获取xml文件
        File file = new File("web/xml/users.xml");
        //2.2解析xml文档，加载文档进内存，获取dom'树-->Document
        try {
            Document document = Jsoup.parse(file, "utf-8");
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
      /*  //2.parse(String html)，解析xml或html字符串
        String str="<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<?xml-stylesheet type=\"text/css\" href=\"a.css\"?>\n" +
                "<users>\n" +
                "    <user id=\"1\">\n" +
                "        <name>张三</name>\n" +
                "        <age>23</age>\n" +
                "        <gender>male</gender>\n" +
                "        <br/>\n" +
                "    </user>\n" +
                "    <user id=\"2\">\n" +
                "        <name>李四</name>\n" +
                "        <age>22</age>\n" +
                "        <gender>fmale</gender>\n" +
                "    </user>\n" +
                "\n" +
                "</users>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/
        //3.parse(URL url,int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        URL url = null;//代表网络中的一个资源路径
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Document document = Jsoup.parse(url, 10000);
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
