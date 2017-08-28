package com.hph.socket;

/**
 * @author hepenghui
 *
 */
public class TestRanqi {
	public static void main(String[] args) throws Exception {
//		queryPrePay();
//		payConfirm();
		queryPay();
//		String clearFile = "|2002|123456|20170809|091921|yikatong|system|system|4001825212|2|1.35|150.00|1708090124793|";
//		System.out.println(SocketUtils.generate(clearFile));
		
	}

	/**
	 * 提交实时交费清算文件(交易代码=2003)
	 * 
	 * @throws Exception
	 */
	public static void commitClearFile() throws Exception {
		CommitClearFileRequestBean bean = new CommitClearFileRequestBean();
		bean.setBankClerkNum("system");
		bean.setBankCode("yikatong");
		bean.setBankNetWorkPoint("system");
		bean.setTradeNum("123456");
		bean.setCode("2003");
		//  交易代码（2003）.银行代码.日期(YYYYMMDD).时间(hhmmss)
		bean.setClearFileName("2003.yikatong.20170809.091921");
		String data = bean.toString();
		System.out.println(data);
		String str = SocketUtils.socket(data);
		System.out.println(str);

	}

	/**
	 * 实时交费确认
	 * 
	 * @throws Exception
	 */
	public static void payConfirm() throws Exception {
		// 查询
		QueryArrearageResponseBean resp = queryArrearage();
		if (resp != null) {
			PayConfirmRequestBean bean = new PayConfirmRequestBean();
			bean.setBankClerkNum("system");
			bean.setBankCode("yikatong");
			bean.setBankNetWorkPoint("system");
			bean.setUserNum("4001825212");
			bean.setTradeNum("123456");
			bean.setCode("2002");
			bean.setUserType(resp.getUserType());
			bean.setBalance(resp.getBalance());
			bean.setActuallyPay("150.00");
			bean.setRecordNum("1");
			bean.setRecordContent(resp.getRecordContent().get(0).getBillRecordId()+"," + resp.getBalance());
			String data = bean.toString();
			System.out.println(data);
			String str = SocketUtils.socket(data);
			PayConfirmResponseBean payConfirmResponseBean = new PayConfirmResponseBean(str);
			System.out.println(payConfirmResponseBean.toString());
		}

	}

	/**
	 * 查询交费明细
	 * 
	 * @throws Exception
	 */
	public static void queryPay() throws Exception {
		QueryPayRequestBean bean = new QueryPayRequestBean();
		bean.setBankClerkNum("system");
		bean.setBankCode("yikatong");
		bean.setBankNetWorkPoint("system");
		bean.setUserNum("4001825212");
		bean.setTradeNum("123456");
		bean.setCode("2004");
		bean.setStartDate("20170509");
		bean.setEndDate("20170808");
		bean.setPayRecordId("1708090124793");
		String data = bean.toString();
		System.out.println(data);
		String str = SocketUtils.socket(data);
		System.out.println(str);

	}
	/**
	 * 查询预存款
	 * 
	 * @throws Exception
	 */
	public static void queryPrePay() throws Exception {
		BaseRequestBean bean = new BaseRequestBean();
		bean.setBankClerkNum("system");
		bean.setBankCode("yikatong");
		bean.setBankNetWorkPoint("system");
		bean.setTradeNum("123456");
		bean.setCode("3001");
		bean.setUserNum("4001825212");
		String data = bean.toString();
		System.out.println(data);
		String str = SocketUtils.socket(data);
		System.out.println(str);
		
	}

	/**
	 * 查询欠费记录
	 * 
	 * @throws Exception
	 */
	public static QueryArrearageResponseBean queryArrearage() throws Exception {
		BaseRequestBean bean = new BaseRequestBean();
		bean.setBankClerkNum("system");
		bean.setBankCode("yikatong");
		bean.setBankNetWorkPoint("system");
		bean.setTradeNum("123456");
		bean.setCode("2001");
		bean.setUserNum("4001825212");
		String data = bean.toString();
		System.out.println(data);
		String str = SocketUtils.socket(data);
		QueryArrearageResponseBean resp = new QueryArrearageResponseBean(str);
		if ("0000".equals(resp.getRespCode())) {
			System.out.println(resp.toString());
			System.out.println(resp.getRecordContent().get(0).toString());
			return resp;
		} else {
			System.out.println(str);
			return null;
		}

	}

}
