package com.hph.smallgreen;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Index {
	
	public static void main(String[] args) throws Exception {
		String url = "http://218.93.33.59:85/map/xcmap/xcapi.asp";
		Document d = Jsoup.connect(url).get();
		String data = d.body().text();
		JSONArray ja = JSONArray.parseArray(data);
		for(Object o:ja){
			JSONObject jsonO = (JSONObject)o;
			System.out.println(jsonO.get("id"));
		}
	}

}
