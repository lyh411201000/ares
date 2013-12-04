package com.zx.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.framework.bean.UserInfo;
import com.zx.framework.dao.UserInfoDao;
import com.zx.framework.service.UserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	@Resource
	private UserInfoDao userInfoDao;
	
	public UserInfo getByAccountAndPsw(String account,String password){
		return null;
	}

	public UserInfo getByAccount(String username) {
		return userInfoDao.getByAccount(username);
	}
	
}
