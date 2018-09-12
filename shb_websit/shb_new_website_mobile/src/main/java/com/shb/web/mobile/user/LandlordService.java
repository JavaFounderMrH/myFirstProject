package com.shb.web.mobile.user;

import java.io.Serializable;

public class LandlordService implements Serializable {

	private static final long serialVersionUID = 6400958252938664839L;

	private Long slsId; // 房东服务主键ID

	private Integer type; // 服务类型

	private String name; // 名称

	public Long getSlsId() {
		return slsId;
	}

	public void setSlsId(Long slsId) {
		this.slsId = slsId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

}