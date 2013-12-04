package com.zx.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.zx.framework.bean.UserInfo;
import com.zx.framework.dao.UserInfoDao;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements
		UserInfoDao {
	public UserInfo getByAccount(String username) {
		return (UserInfo) getSession()
				.createQuery(" from UserInfo user where user.account=:account")
				.setParameter("account", username).uniqueResult();
	}
}
