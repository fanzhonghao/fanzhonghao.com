# Scrapy
实验环境：Ubuntu 16.04  
Scrapy是一个用Python写的Crawler Framework。  
使用Scrapy的框架可以简易地开发出爬取网页的代码。  
安装方法： `sudo pip install Scrapy`.  
在开始爬取之前，需要先创建一个新的Scrapy项目。在将要存放项目的位置，使用命令`scrapy startproject cnblogSpider`，即可创建一个 cnblogSpider 的项目。  
在项目文件 cnblogSpider 下，有文件夹spider，在里面放置Spider代码。  
创建Spider类时，需要继承scrapy.Spider类，并且定义一下三个属性：  
1. name:用于区别Spider。该名字必须是唯一的。  
2. start_url:是Spider在启动时进行爬取的入口URL列表。  
3. parse():是Spider的一个方法，被调用时，每个初始URL响应后返回的Response对象，将会作为唯一的参数传递给该方法，该方法负责解析返回的数据（response data),提取数据（生成item）以及生成需要进一步处理的URL的Request方法。  

一个简单的示例：  

	# -*- coding:utf-8 -*-
	import scrapy
	class CnblogsSpider(scrapy.Spider):
    	name = "cnblogs"
    	allowed_domain = ["cnblogs.com"]
    	start_urls = ["https://github.com/fanzhonghao/fanzhonghao.com"]
    def parse(self, response):
        pass

将该代码保存为 