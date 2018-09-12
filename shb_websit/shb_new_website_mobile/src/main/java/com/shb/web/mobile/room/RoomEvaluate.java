package com.shb.web.mobile.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomEvaluate implements Serializable{
	
    private Long sreId; // 主键ID

    private Integer score; // 评分

    private Long sriRid; // 房间ID

    private Long suiRid;  // 用户ID

    private Integer isDelete; // 逻辑删除

    private String operator;//操作人

    private String createTime; // 创建时间

    private String modifyTime; // 修改时间

    private Long soiRid; // 订单ID

    private String content; // 评价内容
    
    private String evaluateCount; // 评价数量
    
    private String src; // 图片地址
    
    private String username; // 用户名称
    
    private String roomTitle;// 房间名称
    
    private String roomStatus; //房间状态
    
    private String headPortrait; // 头像

    public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getEvaluateCount() {
		return evaluateCount;
	}

	public void setEvaluateCount(String evaluateCount) {
		this.evaluateCount = evaluateCount;
	}

	public Long getSreId() {
        return sreId;
    }

    public void setSreId(Long sreId) {
        this.sreId = sreId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getSriRid() {
        return sriRid;
    }

    public void setSriRid(Long sriRid) {
        this.sriRid = sriRid;
    }

    public Long getSuiRid() {
        return suiRid;
    }

    public void setSuiRid(Long suiRid) {
        this.suiRid = suiRid;
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

    public Long getSoiRid() {
        return soiRid;
    }

    public void setSoiRid(Long soiRid) {
        this.soiRid = soiRid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}