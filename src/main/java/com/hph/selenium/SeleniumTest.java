package com.hph.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		   webDriver.manage().window().maximize();
		   //与浏览器同步非常重要，必须等待浏览器加载完毕
		   webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   //下面这句等价于webDriver.navigate().to("www.baidu.com");
		   webDriver.get("http://www.baidu.com");
		   //在输入框中填写要搜索的内容
		   WebElement kw = webDriver.findElement(By.id("kw"));
		   kw.sendKeys("java用selenium库控制chrome");
		   //点击搜索按钮
		   WebElement su = webDriver.findElement(By.id("su"));
		   su.click();
		   List<WebElement> list = webDriver.findElements(By.className("result"));
		   //寻找包含weiyinfu的搜索条目
		   webDriver.findElement(By.partialLinkText("weiyinfu")).click();
		   //webDriver.close();
		   System.out.println("Hello World!");
	}
}
