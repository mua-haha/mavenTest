package com.hph.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.example.ZhihuPageProcessor;

public class SpiderTest {

	public static void main(String[] args) {
		Spider.create(new ZhihuPageProcessor()).addUrl("https://www.zhihu.com/explore").run();
	}

}
