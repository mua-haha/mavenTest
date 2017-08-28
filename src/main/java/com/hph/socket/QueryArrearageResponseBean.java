package com.hph.socket;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询欠费记录(交易代码=2001) response 封装
 * 
 * @author hepenghui
 *
 */
public class QueryArrearageResponseBean {

	public QueryArrearageResponseBean(String text) {
		String[] str = text.split("\\|");
		length = str[0];
		respCode = str[1];
		respDesc = str[2];
		tradeNum = str[3];
		userNum = str[4];
		userName = str[5];
		userAddr = str[6];
		userType = str[7];
		userTypeDesc = str[8];
		balance = str[9];
		bill = str[10];
		gasCode = str[11];
		recordNum = str[12];

		String data = str[13];
		int num = Integer.valueOf(recordNum);
		List<ArrearageRecord> list = new ArrayList<>();
		String[] datas = data.split(";");
		for(int i=0;i<num;i++){
			list.add(new ArrearageRecord(datas[i]));
		}
		recordContent = list;
		mac = str[14];
	}

	/**
	 * 报文长度 X(4)
	 */
	private String length;
	/**
	 * 响应码 X(4)
	 */
	private String respCode;
	/**
	 * 响应描述 X(60)
	 */
	private String respDesc;
	/**
	 * 交易流水号 X(20)
	 */
	private String tradeNum;
	/**
	 * 用户号 X(20)
	 */
	private String userNum;
	/**
	 * 用户姓名 X(100)
	 */
	private String userName;
	/**
	 * 用户地址 X(140)
	 */
	private String userAddr;
	/**
	 * 客户类型 X(1) 1 工商户 2 零散户 3 团缴户
	 */
	private String userType;
	/**
	 * 客户类型描述 X(20)
	 */
	private String userTypeDesc;
	/**
	 * 上次结余 D(10,2) 帐户可用余额
	 */
	private String balance;
	/**
	 * 应交金额合计 D(10,2)
	 */
	private String bill;
	/**
	 * 燃气公司的分公司代码，用于帐务拆分 机构码 X(20)
	 */
	private String gasCode;
	/**
	 * 欠费记录总数 X(4)
	 */
	private String recordNum;
	/**
	 * 欠费记录内容 X(1600)
	 */
	private List<ArrearageRecord> recordContent;
	/**
	 * MAC校验码 X(8)
	 */
	private String mac;

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTypeDesc() {
		return userTypeDesc;
	}

	public void setUserTypeDesc(String userTypeDesc) {
		this.userTypeDesc = userTypeDesc;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getGasCode() {
		return gasCode;
	}

	public void setGasCode(String gasCode) {
		this.gasCode = gasCode;
	}

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public List<ArrearageRecord> getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(List<ArrearageRecord> recordContent) {
		this.recordContent = recordContent;
	}

	@Override
	public String toString() {
		return "QueryArrearageResponseBean [length=" + length + ", respCode=" + respCode + ", respDesc=" + respDesc + ", tradeNum=" + tradeNum + ", userNum=" + userNum + ", userName=" + userName + ", userAddr=" + userAddr + ", userType=" + userType + ", userTypeDesc=" + userTypeDesc + ", balance=" + balance + ", bill=" + bill + ", gasCode=" + gasCode + ", recordNum=" + recordNum + ", recordContent=" + recordContent + ", mac=" + mac + "]";
	}
	
	

}
