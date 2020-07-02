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