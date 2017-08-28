package com.hph.aaa.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class testping {
	public static void main(String[] args) {

//		isAddressAvailable("192.168.2.1");
//		System.out.println(isConnect());
		String xml = "<Request>"
				+ "<trade_code>2001</trade_code>"
				+ "<identity_card_value>210104199104228511</identity_card_value>"
				+ "<name>房成贯 </name>"
				+ "<Id_card_type_Code>01</Id_card_type_Code>"
				+ "<Id_Document_Value>210104199104228511</Id_Document_Value>"
				+ "<Birth_Time>19910422</Birth_Time>"
				+ "<Gender_Code>1</Gender_Code>"
				+ "<Nation_Code>01</Nation_Code>"
				+ "<Addr1>河南河南许昌</Addr1>"
				+ "<Photo></Photo></Request>";
		System.out.println(sendMessage(xml));
	}

	/**
	 * 测试socket是否连接上
	 * 
	 * @return
	 */
	public static  boolean isConnect() {
		String healthIp = "117.158.96.118";
		int healthPort = 19001;
		boolean bool = true;
		Socket socket = null;
		try {
			socket = new Socket(healthIp, healthPort);
//			System.out.println("调用居民健康卡平台通讯正常");
		} catch (UnknownHostException e) {
			bool = false;
//			System.out.println("-->未知的主机名:" + healthIp + " 异常", e);
		} catch (IOException e) {
			bool = false;
//			System.out.println("-hostName=" + healthIp + " portNum=" + healthPort + "---->IO异常错误" + e, e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {/* close failed */
					socket = null;
				}
			}
		}
		return bool;
	}
	
	/**
	 * 发送socket,居民健康卡
	 * 
	 * @param xml
	 * @return
	 */
	private static String sendMessage(String xml) {
		String healthIp = "192.168.70.73";
		int healthPort = 19001;
		String data = "";
		Socket socket = null;
		InetAddress addr;
		try {
			addr = InetAddress.getByName(healthIp);
			//System.out.println("healthIp:" + healthIp);
			try {
				socket = new Socket(addr, healthPort);
				socket.setSoTimeout(6000);// 设置超时
				System.out.println(healthIp + ":" + healthPort + "连接已经连通！");
				Writer out = new OutputStreamWriter(socket.getOutputStream(),
						"utf-8");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream(), "utf-8"));
				System.out.println("向居民健康卡平台发送内容：" + xml);
				out.write(xml);
				out.flush();
				socket.shutdownOutput();
				String line = null;
				while ((line = in.readLine()) != null) {
					data += line;
				}
				System.out.println("居民健康卡平台返回内容：" + data);
				out.close();
				in.close();
			} catch (UnknownHostException e) {
				System.out.println("Socket Error:" + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO:" + e.getMessage());
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {/* close failed */
						socket = null;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static void isAddressAvailable(String ip) {
		try {
			InetAddress address = InetAddress.getByName(ip);// ping this IP

			if (address instanceof java.net.Inet4Address) {
				System.out.println(ip + " is ipv4 address");
			} else if (address instanceof java.net.Inet6Address) {
				System.out.println(ip + " is ipv6 address");
			} else {
				System.out.println(ip + " is unrecongized");
			}

			if (address.isReachable(5000)) {
				System.out.println("SUCCESS - ping " + ip + " with no interface specified");
			} else {
				System.out.println("FAILURE - ping " + ip + " with no interface specified");
			}

			System.out.println("\n-------Trying different interfaces--------\n");

			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				System.out.println("Checking interface, DisplayName:" + ni.getDisplayName() + ", Name:" + ni.getName());
				System.out.println(ni.isUp());
				if (address.isReachable(ni, 0, 5000)) {
					System.out.println("SUCCESS - ping " + ip);
				} else {
					System.out.println("FAILURE - ping " + ip);
				}

				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					System.out.println("IP: " + ips.nextElement().getHostAddress());
				}
				System.out.println("-------------------------------------------");
			}
		} catch (Exception e) {
			System.out.println("error occurs.");
			e.printStackTrace();
		}
	}

}
