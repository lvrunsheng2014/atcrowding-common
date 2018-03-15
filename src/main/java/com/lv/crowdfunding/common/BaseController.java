package com.lv.crowdfunding.common;

import org.springframework.stereotype.Controller;

import com.lv.crowdfunding.common.bean.AJAXResult;



@Controller
public abstract class BaseController {
	private ThreadLocal<AJAXResult> threadLoad=new ThreadLocal<AJAXResult>();
	protected void start() {
		threadLoad.set(new AJAXResult());
	}

	protected Object end() {
		Object obj=threadLoad.get();
		threadLoad.remove();
		return obj;
	}

	protected void success() {
		success(true);
	}
	protected void data( Object data) {
		AJAXResult result=threadLoad.get();
		result.setData(data);
	}
	
	protected void success(boolean flag) {
		AJAXResult result=threadLoad.get();
		result.setSuccess(flag);
	}

	protected void fail() {
		success(false);
	}
}
