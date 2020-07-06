package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.File;

/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {
    public static void main(String[] args) {
        //2.1获取xml文件
        File file = new File("web/xml/users.xml");
        //2.2解析xml文档，加载文档进内存，获取dom'树-->Document
        try {
            Document document = Jsoup.parse(file, "utf-8");

            //3.获取元素对象
            //3.1获取所有user对象
            Elements elements = document.getElementsByTag("user");
            System.out.println(elements);
            System.out.println("------------------");

            //3.2获取属性名为lalala的元素对象
            Elements elements1 = document.getElementsByAttribute("lalala");
            System.out.println(elements1);
            System.out.println("------------------");

            //3.3获取id属性值为2的元素对象
            Elements elements2 = document.getElementsByAttributeValue("id","2");
            System.out.println(elements2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
