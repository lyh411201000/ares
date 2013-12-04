package com.zx.framework.service;

import com.zx.framework.bean.UserInfo;

public interface UserInfoService {
	UserInfo getByAccountAndPsw(String account,String password);

	UserInfo getByAccount(String username);
}
