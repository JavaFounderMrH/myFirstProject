package com.shb.web.mobile.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomCollection implements Serializable {

	private Long srcId; // 主键ID

	private String username; // 用户名

	private Long sriRid; // 房间ID

	private Integer falg; // 是否收藏(1:收藏)

	public Integer getFalg() {
		return falg;
	}

	public void setFalg(Integer falg) {
		this.falg = falg;
	}

	public Long getSrcId() {
		return srcId;
	}

	public void setSrcId(Long srcId) {
		this.srcId = srcId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public Long getSriRid() {
		return sriRid;
	}

	public void setSriRid(Long sriRid) {
		this.sriRid = sriRid;
	}

}