package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 */
public class JsoupDemo5 {
    public static void main(String[] args) {
        File file = new File("web/xml/users.xml");
        try {
            Document document = Jsoup.parse(file, "utf-8");

            //查询name标签
            Elements elements = document.select("name");
            System.out.println(elements);
            System.out.println();

            //查询id值为2的元素
            Elements elements1 = document.select("#2");
            System.out.println(elements1);
            System.out.println();
            //获取user标签id属性值为1的name下的xing子标签
            Elements elements2 = document.select("user[id='1'] > name > xing");
            System.out.println(elements2);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
