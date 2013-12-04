package com.zx.framework.dao;

import com.zx.framework.bean.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {
	UserInfo getByAccount(String username);
}
