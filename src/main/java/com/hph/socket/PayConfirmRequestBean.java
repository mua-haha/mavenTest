package com.hph.socket;

public class PayConfirmRequestBean extends BaseRequestBean {

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
	 * 费用记录总数 D(4,0)
	 */
	private String recordNum;
	/**
	 * 费用记录总数 D(4,0)
	 */
	private String recordContent;

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

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public String getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
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
			.append(recordNum).append(separator)
			.append(recordContent).append(separator);
		String result = sb.toString().replaceAll("null", "");
		try {
			return SocketUtils.generate(result);
		} catch (Exception e) {
			return "-1";
		}
	}

}
