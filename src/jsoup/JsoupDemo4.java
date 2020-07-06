package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element：元素对象
 * <p>
 * 1. 获取子元素对象
 * getElementsByTag(String tagName)：根据标签名获取元素对象集合
 * getElementsByAttribute(String key)：根据属性名获取元素对象集合
 * getElementsByAttributeValue(String key,String value)：根据标对应的属性名和属性值获取元素对象集合
 * 2. 获取属性值
 * String attr(String key)：根据属性名获取属性值
 * 3. 获取文本内容
 * String text()：获取文本内容
 * String html()：获取标签体的所有内容（宝库哦子标签的字符串内容）
 */
public class JsoupDemo4 {
    public static void main(String[] args) {
        //2.1获取xml文件
        File file = new File("web/xml/users.xml");
        //2.2解析xml文档，加载文档进内存，获取dom'树-->Document
        try {
            Document document = Jsoup.parse(file, "utf-8");

            //通过Document对象获取name标签，获取所有的name标签
            Elements elements = document.getElementsByTag("name");
            System.out.println(elements.size());
            System.out.println("----------------");

            //通过Element对象获取子标签对象
            Element element_user = document.getElementsByTag("user").get(0);
            Elements ele_name = element_user.getElementsByTag("name");
            System.out.println(ele_name.size());
            System.out.println();
            //获取user对象的属性值
            String id = element_user.attr("id");
            System.out.println(id);
            System.out.println();

            //获取文本内容
            String text = ele_name.text();
            String html = ele_name.html();
            System.out.println(text);
            System.out.println();
            System.out.println(html);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
