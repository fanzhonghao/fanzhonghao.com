# -*- coding:utf-8 -*-
import scrapy
class CnblogsSpider(scrapy.Spider):
    name = "cnblogs"
    allowed_domain = ["cnblogs.com"]
    start_urls = ["https://github.com/fanzhonghao/fanzhonghao.com"]
    def parse(self, response):
        pass
