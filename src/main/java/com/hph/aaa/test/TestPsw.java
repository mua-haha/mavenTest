package com.hph.aaa.test;

import java.io.UnsupportedEncodingException;

import com.hph.socket.SocketUtils;

public class TestPsw {

	public static void main(String[] args) throws Exception {
//		String str = "|0000|";
//		byte[] mac = SocketClient.getMac(str.getBytes("GBK"), 8);
//		System.out.println(new String(mac,"GBK"));
		
		
//		String s = "0057|0109|报文数据错：报文length域数值与报文长度不等|fG[.XQ";
//		String str = "|0109|报文数据错：报文length域数值与报文长度不等|fG[.XQ";
//		System.out.println(str.getBytes("GBK").length);
//		byte[] mac = SocketClient.getMac("|0109|报文数据错：报文length域数值与报文长度不等|".getBytes("GBK"), 8);
//		System.out.println(new String(mac,"GBK"));
		
		String s = "0014|0000|<0000<@";
		String str = "|0000|<0000<@";
		System.out.println(str.getBytes("GBK").length);
		byte[] mac = SocketUtils.getMac("|0000|".getBytes("GBK"), 8);
		System.out.println(new String(mac,"GBK"));
		
//		String s = "0055|0105|报文数据错：报文交易代码未知，交易不存在|'iUnoXb";
//		String str = "|0105|报文数据错：报文交易代码未知，交易不存在|'iUnoXb";
//		System.out.println(str.getBytes("GBK").length);
//		byte[] mac = SocketClient.getMac("|0105|报文数据错：报文交易代码未知，交易不存在|".getBytes("GBK"), 8);
//		System.out.println(new String(mac,"GBK"));
		
//		String str = "|0000|";
//		byte[] macs = SocketClient.getMac(str.getBytes("GBK"), 8);
//		String mac = new String(macs,"GBK");
//		str = str + mac;
//		System.out.println(str.getBytes("GBK").length);
		
	}

}
