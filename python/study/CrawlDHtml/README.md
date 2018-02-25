# 抓取动态网站信息
抓取动态网站信息时，有两种方法。  
一种是使用传统代码直接抓取想要抓取的页面内容，代码一般包括四部分，分别为：  
<ul>
<li>网页下载器</li>  
下载网页内容  
<li>网页解析器</li>  
包括两部分：一是从当前网页中提取所需链接，二是从动态加载的链接中提取所需的字段。  
<li>数据存储器</li>  
将数据存入数据库中  
<li>爬虫调度器</li>  
调度以上模块同时负责Ajax动态链接的构造。  
</ul>

另一种方法是 PhantomJS 和 Selenium 来提取信息。  
第二种方法是直接提取浏览器渲染好的结果，不进行Ajax请求分析。  

	直接从JavaScript中提取数据远比PhantomJS + Selenium速度快，占用的系统内存小，但是碰到参数加密的情况分析起来较为复杂，而PhantomJS + Selenium恰好避免此问题，反爬虫能力强。  

<a href = "PhantomJS.md">PhantomJS介绍</a>  
<a href = "Selenium.md">Selenium介绍</a>  