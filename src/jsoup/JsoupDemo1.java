package jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Jsoup快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) {
        //2.获取Document对象，根据xml文档获取
        //2.1获取xml文件
        File file = new File("web/xml/users.xml");
        //2.2解析xml文档，加载文档进内存，获取dom'树-->Document
        try {
            Document document = Jsoup.parse(file, "utf-8");
            //3.获取元素对象
            Elements elements = document.getElementsByTag("name");

            System.out.println(elements.size());
            //3.1获取第一个name的Element对象
            Element element = elements.get(0);
            //3.2获取数据
            String name = element.text();
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
