package com.hph.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class SocketUtils {
	public static void main(String[] args) throws Exception {
		String str = "0089|2004|123456|20170807|162750|yikatong|system|system|4001831006|20170505|20170807|j)XNJ";
		String text = "|2004|123456|20170807|162750|yikatong|system|system|4001831006|20170505|20170807|";
		String data = generate(text);
		System.out.println(data);
	}

	public static String socket(String data) throws Exception {

		// 客户端请求与本机在20006端口建立TCP连接
		Socket client = new Socket("218.29.78.126", 5109);
		client.setSoTimeout(10000);
		// 获取键盘输入
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// 获取Socket的输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		// 获取Socket的输入流，用来接收从服务端发送过来的数据
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream(), Charset.forName("GBK")));
		out.println(data);
		String echo = buf.readLine();
		input.close();

		if (client != null) {
			// 如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
			client.close(); // 只关闭socket，其关联的输入输出流也会被关闭
		}
		return echo;

	}

	/**
	 * 检查 报文格式
	 * 
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static boolean validate(String text) throws Exception {
		String[] str = text.split("\\|");
		Integer length = Integer.valueOf(str[0]);
		String mac = str[str.length - 1];
		String data = text.substring(str[0].length(), text.length() - mac.length());
		if (!mac.equals(new String(getMac(getGBKBytes(data), 8), "GBK"))) {
			return false;
		}
		if (!length.equals(getGBKBytes(data + mac).length)) {
			return false;
		}
		return true;

	}

	/**
	 * 根据data 生成报文（添加长度与mac码）
	 * 
	 * @param data
	 *            格式 --> |0109|报文数据错：报文length域数值与报文长度不等|
	 * @return
	 * @throws Exception
	 */
	public static String generate(String data) throws Exception {
		byte[] bytes = getMac(getGBKBytes(data), 8);
		String mac = new String(bytes, "GBK");
		data += mac;
		int length = getGBKBytes(data).length;
		DecimalFormat de = new DecimalFormat("0000");
		return de.format(length) + data;

	}

	/**
	 * 获得string 的gbk编码的字节数组
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static byte[] getGBKBytes(String str) throws Exception {
		return str.getBytes("GBK");

	}

	public static byte[] getMac(byte[] dt, int mlen) {
		int n, k, len, ilen;
		// original input String length
		len = dt.length;
		// 原始串和mac长度的余数
		k = len % mlen;
		//
		n = mlen - k;
		ilen = len + n;
		byte[] bt = new byte[ilen];
		for (int i = 0; i < len; i++) {
			dt[i] = (byte) (dt[i] > 0x00 ? dt[i] : dt[i] + 256);
			bt[i] = dt[i];
		}
		bt[len] = 127;

		byte bo[] = new byte[mlen];
		for (int i = 0; i < ilen;) {
			for (int j = 0; j < mlen; j++) {
				bo[j] ^= bt[i];
				i++;
			}
		}

		for (int i = 0; i < mlen; i++) {
			// 如果遇到\r \n

			if ((bo[i] >= 0x00 ? bo[i] : bo[i] + 256) >= 0x80) { // "\r"
				bo[i] ^= 0x80;
			}

			if (bo[i] == 0x0d) { // "\r"
				bo[i] = 0x4d;
			}
			if (bo[i] == 0x0a) { // "\n"
				bo[i] = 0x4a;
			}
			if (bo[i] == 0x3a) { // ":"
				bo[i] = 0x7a;
			}
			if (bo[i] == 0x7c) { // "|"
				bo[i] = 0x3c;
			}
			if (bo[i] == 0x00) { // "0"
				bo[i] = 0x40;
			}

		}
		return bo;
	}

}
