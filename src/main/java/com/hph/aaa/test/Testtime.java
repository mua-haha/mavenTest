package com.hph.aaa.test;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hph.socket.SocketUtils;

public class Testtime {

	public static void main(String[] args) throws Exception {

//		DecimalFormat de = new DecimalFormat("0000");
//		System.out.println(de.format(10722));
		
//		System.out.println(DateTime.now().toString("YYYYMMdd"));
//		System.out.println(DateTime.now().toString("HHmmss"));
//		System.out.println(Long.parseLong("1A", 16));
		
//		System.out.println(DateTime.now().toString("yyyyMMddHHmmss"));
		String s = "哈哈哈啦啦哈哈";
		String[] a = s.split("啦啦");
		System.out.println(a.length);

	}

}
