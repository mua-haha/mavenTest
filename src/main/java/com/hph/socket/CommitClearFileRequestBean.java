package com.hph.socket;

public class CommitClearFileRequestBean extends BaseRequestBean {

	/**
	 * 清算文件名	X(60)
	 */
	private String clearFileName;

	public String getClearFileName() {
		return clearFileName;
	}

	public void setClearFileName(String clearFileName) {
		this.clearFileName = clearFileName;
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
			.append(clearFileName).append(separator);
		String result = sb.toString().replaceAll("null", "");
		try {
			return SocketUtils.generate(result);
		} catch (Exception e) {
			return "-1";
		}
	}
}
