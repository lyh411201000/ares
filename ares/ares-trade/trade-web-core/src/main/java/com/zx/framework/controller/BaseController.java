package com.zx.framework.controller;

import javax.servlet.http.HttpServletRequest;

import com.zx.framework.bean.UserInfo;
import com.zx.framework.util.SysNameUtil;

public class BaseController {
	public UserInfo getCurrentUser(HttpServletRequest req){
		return (UserInfo) req.getSession().getAttribute(SysNameUtil.currentUser);
	}
}
