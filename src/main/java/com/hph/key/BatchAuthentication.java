package com.hph.key;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 批量验证密钥的合法程度
 * 
 * @author 吴贝贝
 *
 */
@SuppressWarnings("static-access")
public class BatchAuthentication {
	private final static String DES_JM_KEY = "0000000000000000";// 二次加密是使用的数据

	/**
	 * 判断一一行中多条密钥数据是否合法
	 * 
	 * @param key
	 *            验证使用TK
	 * @param src
	 *            要验证的数据
	 * @param count
	 *            传入的行数，辅助打印信息
	 * @return 成功返回true,失败返回false
	 */
	boolean isRight(String key, String src, int count) {
		DES3 des = new DES3();
		String[] result = src.split("\\|");// 分割单条数据的多个密钥
		String flag = "";
		for (int i = 1; i < result.length; i++) {
			String t_src = result[i].substring(0, 32);// 验证数据源
			String t_sufx = result[i].replace(t_src, "");// 二次加密后验证的数据
			try {
				byte[] t_key = hexStringToBytes(key);// 16进制TK装换成byte[]
				byte[] b = des.decryptMode3DES(t_key, hexStringToBytes(t_src));
				String tt_key = byte2hex(b).replace(":", "");// 解密后的结果为下次加密的key(TK)

				byte[] bb = des.encryptMode3DES(hexStringToBytes(tt_key), hexStringToBytes(DES_JM_KEY));
				String t_result = byte2hex(bb).replace(":", "");// 将解密后的数组转换成16进制字符串
				String tt_result = t_result.substring(0, 6);// 取解密结果的前6位

				if (!t_sufx.equals(tt_result)) {
					flag += "第" + count + "行,第" + i + "组密钥校验失败！失败密钥为" + result[i];
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (flag.length() > 0) {
			System.out.println(flag);
			return false;
		}
		return true;
	}

	/**
	 * byte[]转换成十六进制字符串
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	/**
	 * string to byte[]
	 * 
	 * @param hexString
	 *            the hex string
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	/**
	 * 将char型转换成byte
	 * 
	 * @param c
	 *            char
	 * @return byte
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/**
	 * 验证文件中的密钥是否合法
	 * @param path 文件路径
	 * @param key 验证TK
	 */
	public static void checkKey(String path,String key){
		try {
			String encoding = "UTF-8";
			File file = new File(path);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int count = 1;
				int successcount = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (new BatchAuthentication().isRight(key, lineTxt, count)) {// 执行密钥校验
						successcount++;
					}
					count++;
				}
				System.out.println(successcount + "条校验成功！" + (count - successcount - 1) + "条校验失败！");
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		String key = "C1D0CC88FB9CF22D1AE0432E1B0853AC";
		String path = "C:/data/files/batch";
		File pathFile = new File(path);
		File[] files = pathFile.listFiles();
		for (File f : files) {
			BatchAuthentication.checkKey(f.getAbsolutePath(), key);
		}

	}

}
