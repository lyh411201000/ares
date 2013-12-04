package com.zx.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zx.framework.bean.UserInfo;
import com.zx.framework.util.SysNameUtil;

@Controller
@RequestMapping(value = "/framework/user")
public class UserInfoController {
	@RequestMapping("/to_login")
	public String toLogin(HttpServletRequest request, HttpServletResponse response) {
		return "/adminlogin";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		ModelAndView mav = new ModelAndView("/adminlogin");
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			token.clear();
			UserInfo user = (UserInfo) subject.getPrincipal();
			subject.getSession().setAttribute(SysNameUtil.currentUser, user);
			mav.setViewName("/index");

		} catch (UnknownAccountException ex) {
			ex.printStackTrace();
			request.setAttribute("error", ex.getMessage());

		} catch (IncorrectCredentialsException ex) {
			ex.printStackTrace();
			request.setAttribute("error", ex.getMessage());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("error",
					"Login NOT SUCCESSFUL - cause not known!");
		}
		return mav;
	}
}
