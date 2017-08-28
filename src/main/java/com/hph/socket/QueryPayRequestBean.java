package com.hph.socket;

/**
 * 查询交易明细
 * @author hepenghui
 *
 */
public class QueryPayRequestBean extends BaseRequestBean{
	
	/**
	 * 开始日期
	 */
	private String startDate;
	/**
	 * 结束日期
	 */
	private String endDate;
	/**
	 *缴费记录ID
	 */
	private String payRecordId;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
			.append(startDate).append(separator)
			.append(endDate).append(separator)
			.append(payRecordId).append(separator);
		String result = sb.toString().replaceAll("null", "");
		try {
			return SocketUtils.generate(result);
		} catch (Exception e) {
			return "-1";
		}
	}

}
