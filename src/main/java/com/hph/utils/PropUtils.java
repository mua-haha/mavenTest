package com.hph.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropUtils {
	private static Properties props = new Properties();
	private final static Logger logger = Logger.getLogger(PropUtils.class);
	static {
		try {
			props.load(PropUtils.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			logger.error("读取配置信息失败", e);
		}
	}
	public static String getValue(String key) {
		return props.getProperty(key, "");
	}
}
