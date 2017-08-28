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

/**
 * @ClassName: BatchDecryptFactory
 * @Description: TODO
 * @author: Administrator
 * @date: 2017年1月5日 下午5:34:21
 */
public class BatchDecryptFactory {
	private final static ThreadLocal<BatchDecryptUtils> batchDecryptFactory = new ThreadLocal<BatchDecryptUtils>() {
		@Override
		public BatchDecryptUtils initialValue() {
			return new BatchDecryptUtils();
		}
	};
	
	/** 
	 * @Title: getBatchDecryptUtils 
	 * @Description: 获取解密工厂
	 * @return
	 * @return: BatchDecryptUtils
	 */
	public static BatchDecryptUtils getBatchDecryptUtils() {
		return batchDecryptFactory.get();
	}
}
