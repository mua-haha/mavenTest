package com.hph.gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GsonTest {
	public static String URL = "http://222.143.158.85:8080/xcbase-webservice/share/dataList/30030";

	public static void main(String[] args) throws Exception {

		String str = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:web='http://webservice.xcbase.bmsoft.com.cn/'><soapenv:Header/>" + "<soapenv:Body>" + "<web:process>" + "<request>{'cmd':'301001','common':{'user':{}},'params':{'CARDNUM':'100000199002026638'}}</request>" + "</web:process>" + "</soapenv:Body>" + "</soapenv:Envelope>";
		String result = post(str);
		System.out.println(result);
		Document d =  Jsoup.parse(result);
		System.out.println(d.select("return").text());
	}

	public static String post(String json) {

		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(URL);

		post.setHeader("Content-Type", "application/json;charset=UTF-8");
		// post.addHeader("Authorization", "Basic YWRtaW46");
		String result = "";
		try {

			StringEntity s = new StringEntity(json, "UTF-8");
			s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
			post.setEntity(s);

			// 发送请求
			HttpResponse httpResponse = client.execute(post);

			// 获取响应输入流
			InputStream inStream = httpResponse.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
			StringBuilder strber = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
				strber.append(line + "\n");
			inStream.close();
			result = strber.toString();

		} catch (Exception e) {
			System.out.println("请求异常");
			throw new RuntimeException(e);
		}

		return result;
	}

}
