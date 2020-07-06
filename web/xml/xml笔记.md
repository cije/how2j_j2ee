## XML

  1. 概念：Extensible Markup Languag 可扩展标记语言

     * 可扩展：标签都是自定义的。

     * 功能

       * 存储数据

         1. 配置文件

         2. 在网络中传输

     * XML与HTML的区别

       1. xml标签是自定义的，html标签是预定义的。
       2. xml语法严格，html语法松散。
       3. xml是存储数据的，html是展示数据的。

     - w3c：万维网联盟

2. 语法：

   - 基本语法：

     1. xml文档的后缀名 .xml
     2. xml**第一行**必须定义文档声明
     3. xml文档有且只有一个根标签
     4. 属性值必须使用引号引起来
     5. 标签必须正确关闭
     6. xml标签名区分大小写

   - 快速入门：

     ```xml
     <?xml version="1.0" encoding="utf-8" ?>
     <users>
         <user id="1">
             <name>张三</name>
             <age>23</age>
             <gender>male</gender>
         </user>
         <user id="2">
             <name>李四</name>
             <age>22</age>
             <gender>fmale</gender>
         </user>
     </users>
     ```

     

   - 组成部分：

     1. 文档声明

        1. 格式：` <?xml 属性列表 ?>`
        2. 属性列表：
           - version：版本号，必须的属性
           - encoding：编码方式。告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1
           - standalone：是否独立
             - yes：不依赖其他文件
             - no：依赖其他文件

     2. 指令（了解）：结合css

     3. 标签：标签名称自定义

        - 规则：
          1. 名称可以包含字母、数字以及其他的字符
          2. 名称不能以数字或者标点符号开头
          3. 名称不能以字母xml（或者XML，Xml等等）开始
          4. 名称不能含有空格

     4. 属性：

        id属性值唯一

     5. 文本内容

        - CDATA区：在该区域的数据会被原样展示
          - 格式：`<![CDATA[数据]]>`

   - 约束：规定xml文档的书写规则

     - 作为框架的使用者：
       1. 能够在xml中引入约束文档
       2. 能够简单读懂约束文档
       
     - 分类：
       1. DTD：一种简单的约束技术
       2. Schema：一种复杂的约束技术
       
     - DTD：
       - 引入dtd文档到xml文档中
         - 内部dtd：将约束规则定义在xml文档中
         - 外部dtd：将约束文档定义在外部的dtd文档中
           - 本地：`<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">`
           - 网络：`<!DOCTYPE 根标签名 PUBLIC "dtd文件名" "dtd文件位置url">`
       
     - Schema：

       - 引入：

         1. 填写xml文档的根元素
         2. 引入xsi前缀。`xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`
         3. 引入xsd文件命名空间。`xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"`
         4. 为每一个xsd约束声明一个前缀，作为标识。`xmlns="http://www.itcast.cn/xml"`

         ```xml
         <students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         			xmlns="http://www.itcast.cn/xml"
         			xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd">
         ```

  3. 解析：操作xml文档，将文档中的数据读取到内存中

     - 操作xml文档

       1. 解析（读取）：将文档中的数据读取到内存中
       2. 写入：将内存中的数据保存到xml文档中。持久化的存储。

     - 解析xml的方式

       1. DOM：将标记语言文档一次性加载进内存，在内存中新城一颗dom树。
          - 优点：操作方便，可以对文档中进行CURD中的所有操作
          - 缺点：占内存
       2. SAX：逐行读取，基于事件驱动的。
          - 优点：不占内存
          - 缺点：只能读取

     - xml常见的解析器：

       1. JAXP：sun公司提供的解析器，支持dom和sax两种思想
       2. DOM4J：一款非常优秀的解析器，dom
       3. Jsoup：是一款Java的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM、CSS以及类似于JQuery的操作方法来取出和操作数据。
       4. PULL：Android操作系统内置的解析器，SAX方式的。

     - Jsoup

       - 快速入门：

         - 步骤：

           1. 导入相关jar包
           2. 获取Document对象
           3. 获取对应的标签Element对象
           4. 获取数据

         - 代码：

           ```java
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
           ```

         - 对象的使用

           1. Jsoup：工具类，可以解析html或xml文档，返回Document
              * parse：解析html或xml文档，返回Document
                * ```parse(File file,String charsetName)```：解析xml或html文件
                * ```parse(String html)```：解析xml或html字符串
                * ```parse(URL url,int timeoutMillis)```：通过网络路径获取指定的html或xml的文档对象
           2. Document：文档都西昂，代表内存中的dom树
              - 获取Element对象
                - ```getElementsByTag(String tagName)```：根据标签名获取元素对象集合
                - ```getElementsByAttribute(String key)```：根据属性名获取元素对象集合
                - ```getElementsByAttributeValue(String key,String value)```：根据标对应的属性名和属性值获取元素对象集合
           3. Elements：元素Element对象的集合。可以当作`ArrayList<Element>`来使用
           4. Element：元素对象
              1. 获取子元素对象
                 - ```getElementsByTag(String tagName)```：根据标签名获取元素对象集合
                 - ```getElementsByAttribute(String key)```：根据属性名获取元素对象集合
                 - ```getElementsByAttributeValue(String key,String value)```：根据标对应的属性名和属性值获取元素对象集合
              2. 获取属性值
                 - `String attr(String key)`：根据属性名获取属性值
              3. 获取文本内容
                 - `String text()`：获取所有子标签的纯文本内容
                 - `String html()`：获取标签体的所有内容（包括子标签的字符串内容）
           5. Node：节点对象
              - 是Document和Element的父类

         - 快捷查询方式：

           1. selector：选择器
              - 使用的方法：`Elements select(String cssQuery)`
                - 语法：参考`Selector`类中定义的语法
           2. XPath：XPath即为XML路径语言，它是一种用来确定XML文档中某部分位置的语言。
              - 使用Jsoup的XPath需要额外导入jar包
              - 使用XPath的语法完成查询



