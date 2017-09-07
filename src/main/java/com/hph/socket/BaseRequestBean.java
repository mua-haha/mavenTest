package com.hph.socket;

import org.joda.time.DateTime;

/**
 *  request 通用 封装
 * 
 * @author hepenghui
 *
 */
public class BaseRequestBean {
	
	public BaseRequestBean(){
		this.date = DateTime.now().toString("YYYYMMdd");
		this.time = DateTime.now().toString("HHmmss");
		this.bankClerkNum = "system";
		this.bankCode = "yikatong";
		this.bankNetWorkPoint = "system";
	}
	/**
	 * 报文长度 X(4)
	 */
	public String length;
	/**
	 * 交易代码 X(4)
	 */
	public String code;
	/**
	 * 银行交易流水号 X(20)
	 */
	public String tradeNum;
	/**
	 * 银行日期 X(8)
	 */
	public String date;
	/**
	 * 银行时间 X(6)
	 */
	public String time;
	/**
	 * 银行代码 X(4)
	 */
	public String bankCode;
	/**
	 * 银行网点号 X(30)
	 */
	public String bankNetWorkPoint;
	/**
	 * 银行柜员号 X(20)
	 */
	public String bankClerkNum;
	/**
	 * 用户号 X(20)
	 */
	public String userNum;
	/**
	 * MAC校验码 X(8)
	 */
	public String mac;
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankNetWorkPoint() {
		return bankNetWorkPoint;
	}
	public void setBankNetWorkPoint(String bankNetWorkPoint) {
		this.bankNetWorkPoint = bankNetWorkPoint;
	}
	public String getBankClerkNum() {
		return bankClerkNum;
	}
	public void setBankClerkNum(String bankClerkNum) {
		this.bankClerkNum = bankClerkNum;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String separator = "|";
		sb.append(separator).append(code).append(separator)
			.append(tradeNum).append(separator)
			.append(date).append(separator)
			.append(time).append(separator)
			.append(bankCode).append(separator)
			.append(bankNetWorkPoint).append(separator)
			.append(bankClerkNum).append(separator)
			.append(userNum).append(separator);
		String result = sb.toString().replaceAll("null", "");
		try {
			return SocketUtils.generate(result);
		} catch (Exception e) {
			return "-1";
		}
	}
	

}
