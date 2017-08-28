package com.hph.key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 标准3DES算法实现
 */
public class DES3 {
	private static final String Algorithm = "DESede";

	// keybyte 必须是24字节 如果是16字节，内部自动处理 3DES加密
	// 数据 8字节的倍数
	public static byte[] encryptMode3DES(byte[] keybyte, byte[] src) {
		try {
			if (keybyte.length == 16) {
				byte[] k = new byte[24];
				System.arraycopy(keybyte, 0, k, 0, 16);
				System.arraycopy(keybyte, 0, k, 16, 8);

				keybyte = new byte[24];
				System.arraycopy(k, 0, keybyte, 0, 24);
			}

			// 根据给定的字节数组和算法构造一个密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance("TripleDES/ECB/NoPadding");

			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte 必须是24字节 如果是16字节，内部自动处理 3DES解密
	// 数据 8字节的倍数
	public static byte[] decryptMode3DES(byte[] keybyte, byte[] src) {
		try {
			if (keybyte.length == 16) {
				byte[] k = new byte[24];
				System.arraycopy(keybyte, 0, k, 0, 16);
				System.arraycopy(keybyte, 0, k, 16, 8);

				keybyte = new byte[24];
				System.arraycopy(k, 0, keybyte, 0, 24);
			}

			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance("TripleDES/ECB/NoPadding");

			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

}
