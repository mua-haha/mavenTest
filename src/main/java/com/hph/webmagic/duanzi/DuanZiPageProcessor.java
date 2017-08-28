package com.hph.webmagic.duanzi;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.PhantomJSDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class DuanZiPageProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);

	@Override
	public void process(Page page) {
		page.putField("aa", page.getHtml());
	}

	@Override
	public Site getSite() {
		return site;
	}
	public static void main(String[] args) {
		System.setProperty("phantomjs.binary.path", "C:/phantomjs/phantomjs-2.1.1-windows/bin/phantomjs");
		Spider.create(new DuanZiPageProcessor())
				// 从"https://github.com/code4craft"开始抓
				.addUrl("http://music.163.com")
				.addPipeline(new ConsolePipeline())
				.setDownloader(new PhantomJSDownloader())
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();
	}

}
