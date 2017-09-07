package com.hph.socket;

/**
 * 清算文件 报文 bean
 * @author hepenghui
 *
 */
public class CommitClearFileBean  extends BaseRequestBean{
	
	
	/**
	 * 客户类型 X(1)
	 */
	private String userType;
	/**
	 * 上次结余 D(10,2) 帐户可用余额
	 */
	private String balance;
	/**
	 * 实交金额 D(14,2)
	 */
	private String actuallyPay;
	/**
	 * 缴费记录ID
	 */
	private String payRecordId;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getActuallyPay() {
		return actuallyPay;
	}
	public void setActuallyPay(String actuallyPay) {
		this.actuallyPay = actuallyPay;
	}
	public String getPayRecordId() {
		return payRecordId;
	}
	public void setPayRecordId(String payRecordId) {
		this.payRecordId = payRecordId;
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
			.append(userNum).append(separator)
			.append(userType).append(separator)
			.append(balance).append(separator)
			.append(actuallyPay).append(separator)
			.append(payRecordId).append(separator);
		String result = sb.toString().replaceAll("null", "");
		try {
			return SocketUtils.generate(result);
		} catch (Exception e) {
			return "-1";
		}
	}

	
	

}

