package com.zx.framework.service.impl;

import javax.annotation.Resource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zx.framework.bean.UserInfo;
import com.zx.framework.service.UserInfoService;

public class ShiroDbRealm extends AuthorizingRealm {
	
	@Resource
	private UserInfoService userInfoService;
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object obj = getAvailablePrincipal(principals);
		System.out.println(obj+"------------------");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (username == null) {
			throw new AccountException(
					"Null usernames are not allowed by this realm.");
		}
		UserInfo shiroUser = this.userInfoService.getByAccount(username);
		if (shiroUser == null) {
			throw new UnknownAccountException("this user :[" + username + "]ont exist or areadly deleted!");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser,
				shiroUser.getPassword().toCharArray(), getName());

		return info;
	}

}
