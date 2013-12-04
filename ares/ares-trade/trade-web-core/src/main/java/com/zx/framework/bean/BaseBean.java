package com.zx.framework.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class BaseBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date createTime;
	private String discription;
	
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="discription")
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
}
