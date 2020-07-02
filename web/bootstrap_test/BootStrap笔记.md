## BootStrap

1. ​	概念：一个前端开发的框架，BootStrap来自Twitter，是目前很受欢迎的前端框架。BootStrap是基于HTML、CSS、JavaScript的，它简洁灵活，使得Web开发更加快捷。
   - 框架：一个半成品软件，开发人员可以在框架基础上，再进行开发，简化编码。
   - 好处：
     1. ​	定义了很多的css样式和js插件。
     2. ​	响应式布局。
        - 同一套页面可以兼容不同分辨率的设备快速入门

2. ​	快速入门

   1. 下载BootStrap

   2. 在项目中将三个文件夹复制
```html
	<!DOCTYPE html>
	<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>Bootstrap Hello</title>

		<!-- Bootstrap -->
		<link href="../bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="../bootstrap-3.3.7/js/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="../bootstrap-3.3.7/js/bootstrap.min.js"></script>
      </head>
      <body>
		<h1>你好，世界！</h1>
      </body>
      </html>
```
## 响应式布局

 - 同一套页面可以兼容不同分辨率的设备
 - 实现：依赖于栅格系统：将一行平均分为12个格子，可以指定元素占几个格子
 - 步骤：
   1. 定义容器
      - 容器分类：
        1. container：两边留白
        2. container-fluid：每一种设备都是100%宽度
   2. 定义行。相当于之前的tr 样式：row
   3. 定义元素。指定该元素在不同的设备上，所占的各自数目。样式：col-设备代号-格子数目
      - 设备代号：
        1.  xs：超小屏幕 手机（<768px） col-xs-12
        2.  sm：小屏幕 平板（>=768px）
        3.  md：中等屏幕 桌面显示器（>=992px）
        4.  lg：大屏幕 大桌面显示器（>=1200px）
- 注意：
  1. 一行中如果格子数目超过12，则超出部分自动换行。
  2. 栅格类属性可以向上兼容。栅格类适用于屏幕宽度大于或等于分界点大小的设备。
  3. 如果真实设备宽度小于了设置栅格类属性的设备代码的最小值，会一个元素占满一整行。

## css样式和JS插件

 - 全局css样式

    - 按钮：class="btn btn-default"

    - 图片:

       - class="img-responsive":图片在任意尺寸都占100%

       - 图片形状

          - 方形：

            ```html
            <img src="1..." alt="..." class="img-rounded"/>
            ```

          - 圆形：

            ```html
            <img src="..." alt="..." class="img-circle"/>
            ```

          - 相框形：

            ```html
            <img src="..." alt="..." class="mg-thumbnail"/>
            ```

    - 表格

       - table
       - table-bordered
       - table-hover

    - 表单

      	- 给表单下添加class="form-control"

 - 组件

   	- 导航条
   	- 分页条

 - 插件

   	- 轮播图

## 案例

