package com.hph.socket;

import java.util.ArrayList;
import java.util.List;

public class PayConfirmResponseBean {
	
	public PayConfirmResponseBean(String text){
		String[] str = text.split("\\|");
		length = str[0];
		respCode = str[1];
		respDesc = str[2];
		tradeNum = str[3];
		payRecordId = str[4];
		recordNum = str[5];
		
		String data = str[6];
		int num = Integer.valueOf(recordNum);
		List<String> list = new ArrayList<>();
		String[] datas = data.split(";");
		for(int i=0;i<num;i++){
			list.add(datas[i]);
		}
		recordContent = list;
		mac = str[7];
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
	 * 缴费记录ID
	 */
	private String payRecordId;
	/**
	 * 发票记录总数
	 */
	private String recordNum;
	/**
	 * 发票记录内容
	 */
	private List<String> recordContent;
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

	public String getPayRecordId() {
		return payRecordId;
	}

	public void setPayRecordId(String payRecordId) {
		this.payRecordId = payRecordId;
	}

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public List<String> getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(List<String> recordContent) {
		this.recordContent = recordContent;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "PayConfirmResponseBean [length=" + length + ", respCode=" + respCode + ", respDesc=" + respDesc + ", tradeNum=" + tradeNum + ", payRecordId=" + payRecordId + ", recordNum=" + recordNum + ", recordContent=" + recordContent + ", mac=" + mac + "]";
	}

}
