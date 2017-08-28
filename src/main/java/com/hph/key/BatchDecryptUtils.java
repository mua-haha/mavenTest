/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: BatchDecryptUtils.java 
 * @Prject: batch-decrypt
 * @Package: org.batch.decrypt 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2017年1月5日 下午5:34:21 
 * @version: V1.0   
 */
package com.hph.key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * @ClassName: BatchDecryptUtils
 * @Description: TODO
 * @author: Administrator
 * @date: 2017年1月5日 下午5:34:21
 */
public class BatchDecryptUtils {
	/**
	 * @Title: decrypt
	 * @Description: 解密
	 * @param sSrc
	 * @param key
	 * @return
	 * @return: String
	 */
	private static final String ivParameter = "@35c67!^907k05#o";
	private final Logger logger = Logger.getLogger(BatchDecryptUtils.class);

	public String decrypt(String sSrc, String key) {
		try {
			byte[] raw = key.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = Base64.decodeBase64(sSrc);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			logger.error("解密tk异常", ex);
			ex.printStackTrace();
			return null;
		}
	}
}
