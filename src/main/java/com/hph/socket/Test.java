package com.hph.socket;

import org.springframework.beans.BeanUtils;

public class Test {

	public static void main(String[] args) {
		
		PayConfirmRequestBean payConfirmRequestBean = new PayConfirmRequestBean();
		payConfirmRequestBean.setActuallyPay("169090");
		
		CommitClearFileBean commitClearFileBean = new CommitClearFileBean();
		BeanUtils.copyProperties(payConfirmRequestBean, commitClearFileBean);
		
		System.out.println(commitClearFileBean.getActuallyPay());
		System.out.println(commitClearFileBean.toString());
		
	}
}
