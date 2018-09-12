package com.shb.web.mobile.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomEvaluatePicture implements Serializable {

	private Long srepId; // 评价图主键ID

	private String src; // 图片地址

	private Long sreRid; // sre_rid

	private Integer isDelete; // 逻辑删除

	private String operator; // 操作人

	private String createTime; // 创建时间

	private String modifyTime; // 修改时间

	public Long getSrepId() {
		return srepId;
	}

	public void setSrepId(Long srepId) {
		this.srepId = srepId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src == null ? null : src.trim();
	}

	public Long getSreRid() {
		return sreRid;
	}

	public void setSreRid(Long sreRid) {
		this.sreRid = sreRid;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
}