package com.hph.socket;

/**
 * 欠费记录 Bean
 * 
 * @author hepenghui
 *
 */
public class ArrearageRecord {

	public ArrearageRecord(String data) {
		String[] str = data.split(",");
		billRecordId = str[0];
		billType = str[1];
		billTypeDesc = str[2];
		billDate = str[3];
		num = str[4];
		billAll = str[5];
		discount = str[6];
		lateFee = str[7];
		expend = str[8];
		bill = str[9];
	}

	/**
	 * 费用记录ID
	 */
	private String billRecordId;
	/**
	 * 费用类型
	 */
	private String billType;
	/**
	 * 费用类型描述
	 */
	private String billTypeDesc;
	/**
	 * 账期
	 */
	private String billDate;
	/**
	 * 数量
	 */
	private String num;
	/**
	 * 费用合计
	 */
	private String billAll;
	/**
	 * 优惠合计
	 */
	private String discount;
	/**
	 * 滞纳金
	 */
	private String lateFee;
	/**
	 * 账户支出 就是上回结余
	 */
	private String expend;
	/**
	 * 应交金额 应交金额=费用合计-优惠合计+滞纳金-账户支出
	 */
	private String bill;

	public String getBillRecordId() {
		return billRecordId;
	}

	public void setBillRecordId(String billRecordId) {
		this.billRecordId = billRecordId;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getBillTypeDesc() {
		return billTypeDesc;
	}

	public void setBillTypeDesc(String billTypeDesc) {
		this.billTypeDesc = billTypeDesc;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getBillAll() {
		return billAll;
	}

	public void setBillAll(String billAll) {
		this.billAll = billAll;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getLateFee() {
		return lateFee;
	}

	public void setLateFee(String lateFee) {
		this.lateFee = lateFee;
	}

	public String getExpend() {
		return expend;
	}

	public void setExpend(String expend) {
		this.expend = expend;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "ArrearageRecord [billRecordId=" + billRecordId + ", billType=" + billType + ", billTypeDesc=" + billTypeDesc + ", billDate=" + billDate + ", num=" + num + ", billAll=" + billAll + ", discount=" + discount + ", lateFee=" + lateFee + ", expend=" + expend + ", bill=" + bill + "]";
	}
	
	

}
