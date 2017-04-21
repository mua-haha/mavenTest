package com.hph.test.worm.douban;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DouTest {
	public static String url = "http://120.194.116.170:8086/orgpay/req/listBuilding.do";

	public static void getInfo() throws IOException {
		String user_name = "bfrj_user_test1";
		String user_secret = "bfrj_123456";
		String area_code = "CEA490BE052C4786BF4BBDF3998120DD";
		Date now = new Date();
		long timestamp = now.getTime();
		String str = user_name + timestamp + user_secret;
		String key = DigestUtils.md5Hex(str);
		Map<String,String> data = new HashMap<>();
		data.put("user_name", user_name);
		data.put("key", key);
		data.put("timestamp", timestamp+"");
		data.put("community_id", area_code);
		
		Document d =  Jsoup.connect(url).data(data).get();
		String jsonStr = d.body().text();
		JSONObject o = (JSONObject)JSONObject.parse(jsonStr);
		JSONArray ja = o.getJSONArray("data");
		for(Object ob:ja){
			System.out.println(ob);
		}
		
		System.out.println(d);
		
	}

	public static void main(String[] args) throws IOException {
		DouTest.getInfo();

	}

	

}
